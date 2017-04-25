package org.apache.shiro.web.filter.authc;

import com.sishuok.es.sys.user.entity.User;
import com.sishuok.es.sys.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>User: baofangliang
 * <p>Date: 2017/4/25 上午9:33
 * <p>Version: 1.0
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	@Autowired
	private UserService userService;

	/**
	 * 默认的成功地址
	 */
	private String defaultSuccessUrl;
	/**
	 * 管理员默认的成功地址
	 */
	private String adminDefaultSuccessUrl;

	public void setDefaultSuccessUrl(String defaultSuccessUrl) {
		this.defaultSuccessUrl = defaultSuccessUrl;
	}

	public String getDefaultSuccessUrl() {
		return defaultSuccessUrl;
	}

	public void setAdminDefaultSuccessUrl(String adminDefaultSuccessUrl) {
		this.adminDefaultSuccessUrl = adminDefaultSuccessUrl;
	}

	public String getAdminDefaultSuccessUrl() {
		return adminDefaultSuccessUrl;
	}

	/**
	 * 根据用户选择成功地址
	 *
	 * @return
	 */
	@Override
	public String getSuccessUrl() {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		User user = userService.findByUsername(username);
		if (user != null && Boolean.TRUE.equals(user.getAdmin())) {
			return getAdminDefaultSuccessUrl();
		}
		return getDefaultSuccessUrl();
	}
}
