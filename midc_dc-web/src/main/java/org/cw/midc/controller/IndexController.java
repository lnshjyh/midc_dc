package org.cw.midc.controller;

import org.cw.midc.entity.pojo.MenuTitle;
import org.cw.midc.service.MenuService;
import org.cw.midc.util.UserContextUtil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource
    private MenuService menuService;

    @GetMapping(value ={"/","/index"} )
    public String index(ModelMap modelMap){
        String roleId = (String) UserContextUtil.getAttribute("roleId");
        List<MenuTitle> menuTitleList = menuService.getListByRoleId(roleId);
        modelMap.put("menuList",menuTitleList);
        modelMap.put("roleMap",UserContextUtil.getAttribute("roleMap"));
        return "index";
    }
}
