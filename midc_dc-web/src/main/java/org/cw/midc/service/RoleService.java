package org.cw.midc.service;


import org.cw.midc.ParamFilter;
import org.cw.midc.entity.Role;

import java.util.List;

public interface RoleService{

    void add(Role role);

    void delete(List<String> roleIds);

    void update(Role role);

    List<Role> getList(ParamFilter param);

    Role getByRoleId(String roleId);

    List getRoleMap();
}
