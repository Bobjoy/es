package com.sishuok.es.sys.user.service;

import com.sishuok.es.common.service.BaseService;
import com.sishuok.es.sys.user.entity.User;
import com.sishuok.es.sys.user.entity.UserStatus;
import com.sishuok.es.sys.user.exception.UserBlockedException;
import com.sishuok.es.sys.user.exception.UserNotExistsException;
import com.sishuok.es.sys.user.exception.UserPasswordNotMatchException;
import com.sishuok.es.sys.user.repository.UserRepository;
import com.sishuok.es.sys.user.utils.UserLogUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>User: baofangliang
 * <p>Date: 2017/4/25 下午2:19
 * <p>Version: 1.0
 */

@Service
public class UserService extends BaseService<User, Long> {

	private final PasswordService passwordService;

	@Autowired
	public UserService(PasswordService passwordService) {
		this.passwordService = passwordService;
	}

	@Autowired
	private UserRepository getUserRepository() {
		return (UserRepository) baseRepository;
	}

	public User findByUsername(String username) {
		if(StringUtils.isEmpty(username)) {
			return null;
		}
		return getUserRepository().findByUsername(username);
	}

	public User login(String username, String password) {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			UserLogUtils.log(
				username,
				"loginError",
				"username is empty");
			throw new UserNotExistsException();
		}
		//密码如果不在指定范围内 肯定错误
		if (password.length() < User.PASSWORD_MIN_LENGTH || password.length() > User.PASSWORD_MAX_LENGTH) {
			UserLogUtils.log(
				username,
				"loginError",
				"password length error! password is between {} and {}",
				User.PASSWORD_MIN_LENGTH, User.PASSWORD_MAX_LENGTH);

			throw new UserPasswordNotMatchException();
		}

		//此处需要走代理对象，目的是能走缓存切面
		UserService proxyUserService = (UserService) AopContext.currentProxy();

		User user = proxyUserService.findByUsername(username);
		if (user == null || Boolean.TRUE.equals(user.getDeleted())) {
			UserLogUtils.log(
				username,
				"loginError",
				"user is not exists!");

			throw new UserNotExistsException();
		}

		passwordService.validate(user, password);

		if (user.getStatus() == UserStatus.blocked) {
			UserLogUtils.log(
				username,
				"loginError",
				"user is blocked!");
			throw new UserBlockedException(UserStatus.blocked.getInfo()/*userStatusHistoryService.getLastReason(user)*/);
		}

		UserLogUtils.log(
			username,
			"loginSuccess",
			"");
		return user;
	}
}
