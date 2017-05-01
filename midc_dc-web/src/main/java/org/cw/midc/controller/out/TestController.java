package org.cw.midc.controller.out;

import com.google.common.collect.Maps;

import org.cw.midc.entity.oauth.OauthAccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/out/basic")
public class TestController {
    
    @PostMapping("test")
    @ResponseBody
    public Map<String,Object> doLoginForClient(HttpServletRequest httpRequest)  {
        String msg = "";
        Map<String,Object> map = Maps.newHashMap();
        OauthAccessToken obj = (OauthAccessToken)httpRequest.getAttribute("oauthToken");
        map.put("msg",obj.getClientId() );
        map.put("resultCode", "success");
        return map;
    }
}
