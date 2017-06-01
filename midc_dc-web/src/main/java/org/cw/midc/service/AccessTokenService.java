package org.cw.midc.service;

import javax.annotation.Resource;

import org.cw.midc.dao.oauth.OauthAccessTokenDao;
import org.cw.midc.entity.oauth.OauthAccessToken;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenService {
	
	@Resource
	private OauthAccessTokenDao oauthAccessTokenDao;
	
	public AccessTokenService(OauthAccessTokenDao oauthAccessTokenDao) {
		super();
		this.oauthAccessTokenDao = oauthAccessTokenDao;
	}

	public void setOauthAccessTokenDao(OauthAccessTokenDao oauthAccessTokenDao) {
		this.oauthAccessTokenDao = oauthAccessTokenDao;
	}

	public OauthAccessToken getAccessTokenBytoken(String token){
		OauthAccessToken tokenObj = oauthAccessTokenDao.findUnique("getByAccessToken", token);
		return tokenObj;
	}

}