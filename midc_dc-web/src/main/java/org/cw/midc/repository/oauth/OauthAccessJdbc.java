package org.cw.midc.repository.oauth;

import org.cw.midc.model.oauth.OauthAccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

public class OauthAccessJdbc {

    protected JdbcTemplate jdbcTemplate;
    
    
    public OauthAccessJdbc(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public OauthAccessToken get(String token) {
		OauthAccessToken result = null;
		try {
			result = jdbcTemplate.queryForObject("select * from oauth_access_token where access_token = ?",createMapper(),token);
		} catch (Exception e) {
			return null;
		}
		return result;
    }
	

	private RowMapper<OauthAccessToken> createMapper() {
      return BeanPropertyRowMapper.newInstance(OauthAccessToken.class);
    }

}
