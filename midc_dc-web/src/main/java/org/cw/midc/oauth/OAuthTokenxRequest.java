package org.cw.midc.oauth;

import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

public class OAuthTokenxRequest extends OAuthTokenRequest{

    public OAuthTokenxRequest(HttpServletRequest request) throws OAuthSystemException, OAuthProblemException {
        super(request);
    }

    public HttpServletRequest request() {
        return this.request;
    }
}
