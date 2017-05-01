package org.cw.midc.controller.out.oauth;

import javax.servlet.http.HttpServletRequest;

import org.cw.midc.Response;
import org.cw.midc.entity.oauth.OauthAccessToken;
import org.cw.midc.service.HeartBeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 专门测试心跳用
 * @author Administrator
 *
 */
@RestController
@RequestMapping("res/basic")
public class HeartBeatOAuthController {
	
	@Autowired
	private  HeartBeatService heartBeatService;
	
	@GetMapping("heartbeat")
	public Response heartBeat(HttpServletRequest httpRequest)
	{
		Response response = new Response();
		OauthAccessToken obj = (OauthAccessToken)httpRequest.getAttribute("oauthToken");
		String clientId = obj.getClientId();
		heartBeatService.updateLastHeartBeatTime(clientId);
		response.setMsg("OK");
		return response;
	}

}
