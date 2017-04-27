package org.cw.midc.oauth;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.message.types.TokenType;
import org.cw.midc.dao.HospitalDao;
import org.cw.midc.dao.oauth.OauthAccessTokenDao;
import org.cw.midc.entity.Hospital;
import org.cw.midc.entity.oauth.OauthAccessToken;
import org.cw.midc.repository.HospitalRepository;
import org.cw.midc.repository.oauth.OauthAccessTokenRepository;
import org.cw.midc.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Oauth2Handler {
	
	@Autowired
	private OauthAccessTokenDao oauthAccessTokenDao;
	
	@Autowired
	private HospitalDao hospitalDao;

    public final static int REFRESH_TOKEN_VALIDITY_SECONDS = 60 * 60 * 24 * 30;

    public final static int ACCESS_TOKEN_VALIDITY_SECONDS = 60 * 60 * 12;
    
    protected static long THOUSAND = 1000L;
    
    private static final Logger log = LoggerFactory.getLogger(Oauth2Handler.class);
	

	public OAuthResponse processOauthRq(OAuthTokenxRequest tokenRequest, HttpServletResponse response) throws OAuthSystemException{
		 String grantType = tokenRequest.getGrantType();
		 Hospital clientHos = hospitalDao.findUnique("getByClientId", tokenRequest.getClientId());
		 if(clientHos == null){
			 return invalidClientErrorResponse(tokenRequest);
		 }
		 String secret = clientHos.getClientSecret();
		 if(!secret.equals(tokenRequest.getClientSecret())){
			 return invalidClientSecretResponse(tokenRequest);
		 }
		 OauthAccessToken tokenObj = oauthAccessTokenDao.findUnique("getByClientId", tokenRequest.getClientId());
		 boolean isNeedCreate = false;
		 
         if(GrantType.CLIENT_CREDENTIALS.toString().equalsIgnoreCase(grantType)){
        	 if(tokenObj != null){
        		 if(isExpire(tokenObj,ACCESS_TOKEN_VALIDITY_SECONDS)){
        			 oauthAccessTokenDao.delete("deleteByClientId", tokenRequest.getClientId());
        			 isNeedCreate = true;
        		 }
        		 else{
        			 //use old
        			 log.debug("user old");
        		 }
        	 }
        	 else{
        		 isNeedCreate = true;
        	 }
        	 if(isNeedCreate){
        		 tokenObj = null;
        		 tokenObj = saveTokenObj(tokenRequest);
        	 }
        	 return buildTokenResponse(tokenObj);
        	 
         }
         else if(GrantType.REFRESH_TOKEN.toString().equalsIgnoreCase(grantType)){
        	 if(tokenObj != null){
        		if(!tokenRequest.getRefreshToken().equals(tokenObj.getRefreshToken())){
              		return invalidClientErrorResponse(tokenRequest);
              	}
        	  }
        	 tokenObj = null;
    		 tokenObj = saveTokenObj(tokenRequest);
        	 return buildTokenResponse(tokenObj);
         	
         }
         else {
         	return invalidGrantTypeResponse(grantType);
         }
	}
	
	private OauthAccessToken saveTokenObj(OAuthTokenxRequest tokenRequest){
		 OauthAccessToken tokenObj = new OauthAccessToken();
		 tokenObj = this.buildAccessTokenObj(tokenObj,tokenRequest);
		 oauthAccessTokenDao.save(tokenObj);
		 return tokenObj;
	}
	
	private OAuthResponse buildTokenResponse(OauthAccessToken tokenObj) throws OAuthSystemException {
        final OAuthASResponse.OAuthTokenResponseBuilder builder = OAuthASResponse
                .tokenResponse(HttpServletResponse.SC_OK)
                .setAccessToken(tokenObj.getAccessToken())
                .setExpiresIn(String.valueOf(tokenObj.getRefreshTokenExpiredSeconds()))
                .setRefreshToken(tokenObj.getRefreshToken())
                .setTokenType(tokenObj.getTokenType());

        return builder.buildJSONMessage();
    }
	
	private OauthAccessToken buildAccessTokenObj(OauthAccessToken tokenObj,OAuthTokenxRequest tokenRequest){
		tokenObj.setAccessToken(CommonUtils.generateId());
		tokenObj.setRefreshToken(CommonUtils.generateId());
		tokenObj.setClientId(tokenRequest.getClientId());
		tokenObj.setTokenType(TokenType.BEARER.name());
		tokenObj.setTokenExpiredSeconds(ACCESS_TOKEN_VALIDITY_SECONDS);
		tokenObj.setRefreshTokenExpiredSeconds(REFRESH_TOKEN_VALIDITY_SECONDS);
		tokenObj.setCreateTime(new Date());
		
		return tokenObj;
	}
	
	private boolean isExpire(OauthAccessToken token,int expiretime){
		if(token.getCreateTime() == null){
			return false;
		}
		final long time = token.getCreateTime().getTime() + (expiretime * THOUSAND);
        return time < new Date().getTime();
	}
	
	protected OAuthResponse invalidGrantTypeResponse(String grantType) throws OAuthSystemException {
        return OAuthResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
                .setError(OAuthError.TokenResponse.INVALID_GRANT)
                .setErrorDescription("Invalid grant_type '" + grantType + "'")
                .buildJSONMessage();
    }
	
	protected OAuthResponse invalidClientSecretResponse(OAuthTokenxRequest tokenRequest) throws OAuthSystemException {
        return OAuthResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
                .setError(OAuthError.TokenResponse.UNAUTHORIZED_CLIENT)
                .setErrorDescription("Invalid client_secret by client_id '" + tokenRequest.getClientId() + "'")
                .buildJSONMessage();
    }
	
	protected OAuthResponse invalidClientErrorResponse(OAuthTokenxRequest tokenRequest) throws OAuthSystemException {
        return OAuthResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
                .setError(OAuthError.TokenResponse.INVALID_CLIENT)
                .setErrorDescription("Invalid client_id '" + tokenRequest.getClientId() + "'")
                .buildJSONMessage();
    }
	
	
}
