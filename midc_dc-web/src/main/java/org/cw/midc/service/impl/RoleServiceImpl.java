package org.cw.midc.service.impl;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.cw.midc.IdGenerator;
import org.cw.midc.ParamFilter;
import org.cw.midc.dao.RoleDao;
import org.cw.midc.dao.RoleMenuDao;
import org.cw.midc.entity.Role;
import org.cw.midc.service.RoleService;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Resource
    private RoleMenuDao roleMenuDao;

    @Override
    public void add(Role role) {
        checkNotNull(role,"角色信息不能为空");
        checkArgument(!Strings.isNullOrEmpty(role.getName()),"角色名称不能为空");
        Role model = roleDao.findUnique("getRoleByRoleId", role.getRoleId());
        checkArgument(model==null,"角色编码已经存在");
        roleDao.save("addRole", role);
    }

    @Override
    public void delete(List<String> roleIds) {
        for (String roleId : roleIds) {
            Role model = roleDao.findUnique("getRoleByRoleId", roleId);
            checkNotNull(model,"角色对象不存在");
        }
        for (String roleId : roleIds) {
            roleDao.update("deleteByRoleId", roleId);
            roleMenuDao.update("deleteByRoleId", roleId);
        }
    }

    @Override
    public void update(Role role) {
        checkNotNull(role,"角色信息不能为空");
        checkArgument(!Strings.isNullOrEmpty(role.getName()),"角色名称不能为空");

        Role model = roleDao.findUnique("getRoleByRoleId", role.getRoleId());
        checkNotNull(model,"角色对象不存在");

        Map<String, Object> param = Maps.newHashMap();
        param.put("roleId", role.getRoleId());
        model = roleDao.findUnique("getRoleByRoleId", param);
        checkArgument(model==null,"角色标识已存在");

        param = Maps.newHashMap();
        param.put("name", role.getName());
        param.put("roleId", role.getRoleId());
        roleDao.update("updateRole", param);
    }

    @Override
    public List<Role> getList(ParamFilter paramFilter) {
        return roleDao.find("getRoleList", paramFilter.getParam(), paramFilter.getPage());
    }

    @Override
    public Role getByRoleId(String roleId) {
        checkArgument(!Strings.isNullOrEmpty(roleId),"角色编号不能为空");
        Role role = roleDao.findUnique("getRoleByRoleId", roleId);
        checkNotNull(role,"角色对象不存在");
        return role;
    }

    @Override
    public List getRoleMap() {
        return roleDao.findMap( "getRoleIdAndName" );
    }
}
