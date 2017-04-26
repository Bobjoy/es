package org.apache.shiro.realm;

import com.sishuok.es.sys.user.entity.User;
import com.sishuok.es.sys.user.exception.*;
import com.sishuok.es.sys.user.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>User: baofangliang
 * <p>Date: 2017/4/25 上午9:16
 * <p>Version: 1.0
 */
public class UserRealm extends AuthorizingRealm {

	private static final Logger log = LoggerFactory.getLogger("es-error");

	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername().trim();
		String password = "";
		if (upToken.getPassword() != null) {
			password = new String(upToken.getPassword());
		}

		User user;
		try {
			user = userService.login(username, password);
		} catch (UserNotExistsException e) {
			throw new UnknownAccountException(e.getMessage(), e);
		} catch (UserPasswordNotMatchException e) {
			throw new AuthenticationException(e.getMessage(), e);
		} catch (UserPasswordRetryLimitExceedException e) {
			throw new ExcessiveAttemptsException(e.getMessage(), e);
		} catch (UserBlockedException e) {
			throw new LockedAccountException(e.getMessage(), e);
		} catch (Exception e) {
			log.error("login error", e);
			throw new AuthenticationException(new UserException("user.unknown.error", null));
		}

		return new SimpleAuthenticationInfo(user.getUsername(), password.toCharArray(), getName());
	}

}
