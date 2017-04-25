package org.apache.shiro.web.filter.user;

import com.sishuok.es.common.Constants;
import com.sishuok.es.sys.user.entity.User;
import com.sishuok.es.sys.user.service.UserService;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>User: baofangliang
 * <p>Date: 2017/4/25 上午9:29
 * <p>Version: 1.0
 */
public class SysUserFilter extends AccessControlFilter {

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		return true;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
		return false;
	}
}
