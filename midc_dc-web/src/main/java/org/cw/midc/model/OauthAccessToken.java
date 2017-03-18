package org.cw.midc.model;

import java.util.Date;

import org.cw.midc.BaseEntity;

public class OauthAccessToken  extends BaseEntity{
    private Date createTime;

    private String accessToken;

    private Integer tokenExpiredSeconds;

    private String clientId;

    private String tokenType;

    private Integer refreshTokenExpiredSeconds;

    private String refreshToken;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public Integer getTokenExpiredSeconds() {
        return tokenExpiredSeconds;
    }

    public void setTokenExpiredSeconds(Integer tokenExpiredSeconds) {
        this.tokenExpiredSeconds = tokenExpiredSeconds;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType == null ? null : tokenType.trim();
    }

    public Integer getRefreshTokenExpiredSeconds() {
        return refreshTokenExpiredSeconds;
    }

    public void setRefreshTokenExpiredSeconds(Integer refreshTokenExpiredSeconds) {
        this.refreshTokenExpiredSeconds = refreshTokenExpiredSeconds;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken == null ? null : refreshToken.trim();
    }
}