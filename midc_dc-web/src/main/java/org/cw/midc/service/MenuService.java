package org.cw.midc.service;


import org.cw.midc.Response;
import org.cw.midc.ParamFilter;
import org.cw.midc.entity.Menu;
import org.cw.midc.entity.pojo.MenuTitle;

import java.util.List;

public interface MenuService {

	void add(Menu menu);

	void delete(List<String> menuIds);

	void update(Menu menu);

	List<MenuTitle> getListByRoleId(String roleId);
	
	List<Menu> getList(ParamFilter param);

	List<Menu> getByParentId(String menuId);
	
	Response getResTree(String roleId);
	
	Response getSelectResTree();

	Menu detail(String menuId);

	Response getTree();

}
