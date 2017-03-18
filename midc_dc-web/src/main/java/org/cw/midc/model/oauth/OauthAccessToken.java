package org.cw.midc.model.oauth;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oauth_access_token")
public class OauthAccessToken {
	@Column(name = "create_time")
	private Date createTime;

	@Id
	@Column(name = "access_token", length = 32)
    private String accessToken;

	@Column(name = "token_expired_seconds")
    private Integer tokenExpiredSeconds;

	@Column(name = "client_id", length = 32)
    private String clientId;

	@Column(name = "token_type", length = 255)
    private String tokenType;

	@Column(name = "refresh_token_expired_seconds")
    private Integer refreshTokenExpiredSeconds;

	@Column(name = "refresh_token", length = 32)
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
