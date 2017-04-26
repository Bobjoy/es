package org.apache.shiro.web.filter.sync;

import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>User: baofangliang
 * <p>Date: 2017/4/25 上午9:18
 * <p>Version: 1.0
 */
public class SyncOnlineSessionFilter extends PathMatchingFilter {

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		return true;
	}
}
