package com.sishuok.es.sys.resource.service;

import com.sishuok.es.common.entity.search.SearchOperator;
import com.sishuok.es.common.entity.search.Searchable;
import com.sishuok.es.common.plugin.serivce.BaseTreeableService;
import com.sishuok.es.sys.resource.entity.Resource;
import com.sishuok.es.sys.resource.entity.tmp.Menu;
import com.sishuok.es.sys.user.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * <p>User: baofangliang
 * <p>Date: 2017/4/26 下午1:54
 * <p>Version: 1.0
 */

@Service
public class ResourceService extends BaseTreeableService<Resource, Long> {

	public List<Menu> findMenus(User user) {
		Searchable searchable =
			Searchable.newSearchable()
				.addSearchFilter("show", SearchOperator.eq, true)
				.addSort(new Sort(Sort.Direction.DESC, "parentId", "weight"));

		List<Resource> resources = findAllWithSort(searchable);

		return convertToMenus(resources);
	}

	private static List<Menu> convertToMenus(List<Resource> resources) {

		if (resources.size() == 0) {
			return Collections.EMPTY_LIST;
		}

		Menu root = convertToMenu(resources.remove(resources.size() - 1));

		recursiveMenu(root, resources);
		List<Menu> menus = root.getChildren();
		removeNoLeafMenu(menus);

		return menus;
	}

	private static Menu convertToMenu(Resource resource) {
		return new Menu(resource.getId(), resource.getName(), resource.getIcon(), resource.getUrl());
	}

	private static void removeNoLeafMenu(List<Menu> menus) {
		if (menus.size() == 0) {
			return;
		}
		for (int i = menus.size() - 1; i >= 0; i--) {
			Menu m = menus.get(i);
			removeNoLeafMenu(m.getChildren());
			if (!m.isHasChildren() && StringUtils.isEmpty(m.getUrl())) {
				menus.remove(i);
			}
		}
	}

	private static void recursiveMenu(Menu menu, List<Resource> resources) {
		for (int i = resources.size() - 1; i >= 0; i--) {
			Resource resource = resources.get(i);
			if (resource.getParentId().equals(menu.getId())) {
				menu.getChildren().add(convertToMenu(resource));
				resources.remove(i);
			}
		}

		for (Menu subMenu : menu.getChildren()) {
			recursiveMenu(subMenu, resources);
		}
	}
}
