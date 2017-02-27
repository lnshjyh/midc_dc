package org.cw.midc.service;


import org.cw.midc.entity.RoleMenu;

import java.util.List;

public interface RoleMenuService {

    List<RoleMenu> getList(String roleId);

    void update(String roleId, String[] menuIds);

	List<String> getMenuByRole(String roleId);
}
