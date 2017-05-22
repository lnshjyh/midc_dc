package org.cw.midc.shiro.filter;

import org.cw.midc.Response;
import org.cw.midc.entity.oauth.OauthAccessToken;
import org.cw.midc.service.AccessTokenService;
import org.cw.midc.util.ServletUtil;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class Oauth2Filter extends AccessControlFilter {

	private Logger logger = LoggerFactory.getLogger(Oauth2Filter.class);
	
	@Resource
	private AccessTokenService accessTokenService;


	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String accessToken = httpRequest.getParameter("access_token");
		OauthAccessToken tokenObj = accessTokenService.getAccessTokenBytoken(accessToken);
		if(tokenObj == null){
			return false;
		}
		httpRequest.setAttribute("oauthToken", tokenObj);
		
		return true;
	}
	

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		Map<String, Object> retMap = new HashMap<>();
		retMap.put("status", Response.ERROR);
		retMap.put("msg", "invalide token");
		ServletUtil.write(WebUtils.toHttp(response), retMap);
		return false;
	}

}
