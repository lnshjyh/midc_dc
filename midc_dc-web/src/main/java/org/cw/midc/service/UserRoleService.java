package org.cw.midc.service;

import org.cw.midc.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRole> getListByUserId(String userId);

    List<String> getRoleIdsByUserId(String userId);

    void add(String[] roleIds,String userId);
    
    List<String> getRolesByUserId(String userId);
}
