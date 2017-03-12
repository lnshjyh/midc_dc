package org.cw.midc.controller.out;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.cw.midc.entity.Role;
import org.cw.midc.entity.User;
import org.cw.midc.entity.UserRole;
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

@Controller
@RequestMapping("/out")
public class LoginForClientController {

    @Resource
    private RoleService roleService;

    @Resource
    private UserRoleService userRoleService;
    
    @PostMapping("loginForClient")
    @ResponseBody
    public Map<String,Object> doLoginForClient(String account, String password)  {
        String msg = "",resultCode="";
        Map<String,Object> map = Maps.newHashMap();
        resultCode = "SUCCESS";
        if(Strings.isNullOrEmpty(account) || Strings.isNullOrEmpty(password) ){
            msg = "帐号或者密码错误;";
            map.put("msg", msg);
            map.put("resultCode", "ERROR");
            return map;
        }
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        Subject subject = SecurityUtils.getSubject();
        ServletUtil.getRequest().setAttribute("account",account);
        try {
            subject.login(token);
            User user = (User) UserContextUtil.getAttribute("currentUser");
            map.put("user", user);
            List<UserRole> userRoleList = userRoleService.getListByUserId(user.getUserId());
            if(userRoleList==null || userRoleList.size()==0){
            	msg = "用户未授权任何角色";
                map.put("msg", msg);
                return map;
            }
            userRoleList.forEach(userRole -> {
                Role role = roleService.getByRoleId(userRole.getRoleId());
                map.put("role", role);
            });
        } catch (IncorrectCredentialsException | UnknownAccountException e) {
        	resultCode = "ERROR";
            msg = "帐号或者密码错误;";
        } catch (ExcessiveAttemptsException e) {
        	resultCode = "ERROR";
            msg = "登录失败次数过多;";
        } catch (LockedAccountException e) {
        	resultCode = "ERROR";
            msg = "帐号已被锁定;";
        } catch (DisabledAccountException e) {
        	resultCode = "ERROR";
            msg="帐号已被禁用;";
        } catch (ExpiredCredentialsException e) {
        	resultCode = "ERROR";
            msg = "帐号已过期;";
        } catch (UnauthorizedException e) {
        	resultCode = "ERROR";
            msg="帐号未分配角色或权限;";
        }catch (Exception e){
        	resultCode = "ERROR";
            msg="系统发生错误，请联系管理员;";
        }
        map.put("msg", msg);
        map.put("resultCode", resultCode);
        return map;
    }
}
