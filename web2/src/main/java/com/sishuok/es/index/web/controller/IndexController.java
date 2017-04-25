package com.sishuok.es.index.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>User: baofangliang
 * <p>Date: 2017/4/24 下午4:53
 * <p>Version: 1.0
 */
@Controller("adminIndexController")
@RequestMapping("/admin")
public class IndexController {

	//spring3.2.2 bug see  http://jinnianshilongnian.iteye.com/blog/1831408
	@RequestMapping("/index")
	public String index() {

		return "admin/index/index";
	}
}
