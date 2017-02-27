package org.cw.midc.controller;

import org.cw.midc.entity.Role;
import org.cw.midc.entity.User;
import org.cw.midc.service.RoleService;
import org.cw.midc.service.UserService;
import org.cw.midc.util.SystemInfoUtil;
import org.cw.midc.util.UserContextUtil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class HomeController {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @GetMapping("home")
    public String home(ModelMap modelMap) {
        modelMap.put("systemInfo", SystemInfoUtil.getSystemInfo());
        User user = userService.getByUserId(UserContextUtil.getUserId());
        Role role = roleService.getByRoleId(UserContextUtil.getCurrentRoleId());
        modelMap.put("account",user.getAccount());
        modelMap.put("lastLoginIp",user.getLoginIp());
        modelMap.put("role",role.getName());
        return "home";
    }
}
