package com.sishuok.es.index.web.controller;

import com.sishuok.es.sys.resource.entity.tmp.Menu;
import com.sishuok.es.sys.resource.service.ResourceService;
import com.sishuok.es.sys.user.entity.User;
import com.sishuok.es.sys.user.web.bind.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>User: baofangliang
 * <p>Date: 2017/4/24 下午4:53
 * <p>Version: 1.0
 */
@Controller("adminIndexController")
@RequestMapping("/admin")
public class IndexController {

	@Autowired
	private ResourceService resourceService;

	@RequestMapping("/index")
	public String index(@CurrentUser User user, Model model) {

		List<Menu> menus = resourceService.findMenus(user);
		model.addAttribute("menus", menus);

		return "admin/index/index";
	}
}
