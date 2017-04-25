package org.apache.shiro.web.filter.online;

import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>User: baofangliang
 * <p>Date: 2017/4/25 上午9:31
 * <p>Version: 1.0
 */
public class OnlineSessionFilter extends AccessControlFilter {
	@Override
	protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
		return false;
	}
}
