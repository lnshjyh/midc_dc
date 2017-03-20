package org.cw.midc.controller.out.oauth;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.cw.midc.oauth.OAuthTokenxRequest;
import org.cw.midc.oauth.Oauth2Handler;
import org.cw.midc.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oauth")
public class Oauth2Controller {
	
	@Resource
	private Oauth2Handler oauth2Handler;

	@RequestMapping("token")
    public void authorize(HttpServletRequest request, HttpServletResponse response) throws OAuthSystemException {
        try {
        	OAuthTokenxRequest tokenRequest = new OAuthTokenxRequest(request);
        	OAuthResponse oAuthResponse = oauth2Handler.processOauthRq(tokenRequest, response);
        	WebUtils.writeOAuthJsonResponse(response, oAuthResponse);

        } catch (OAuthProblemException e) {
        	OAuthResponse oAuthResponse = OAuthASResponse
                    .errorResponse(HttpServletResponse.SC_FOUND)
                    .location(e.getRedirectUri())
                    .error(e)
                    .buildJSONMessage();
        	WebUtils.writeOAuthJsonResponse(response, oAuthResponse);
        }

    }
}
