package org.cw.midc.controller.out;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.cw.midc.entity.Role;
import org.cw.midc.entity.User;
import org.cw.midc.entity.UserRole;
import org.cw.midc.model.oauth.OauthAccessToken;
import org.cw.midc.service.RoleService;
import org.cw.midc.service.UserRoleService;
import org.cw.midc.util.ServletUtil;
import org.cw.midc.util.UserContextUtil;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/out/basic")
public class TestController {

    @Resource
    private RoleService roleService;

    @Resource
    private UserRoleService userRoleService;
    
    @PostMapping("test")
    @ResponseBody
    public Map<String,Object> doLoginForClient(HttpServletRequest httpRequest,String account, String password)  {
        String msg = "",resultCode="";
        Map<String,Object> map = Maps.newHashMap();
        OauthAccessToken obj = (OauthAccessToken)httpRequest.getAttribute("oauthToken");
        map.put("msg",obj.getClientId() );
        map.put("resultCode", "success");
        return map;
    }
}
