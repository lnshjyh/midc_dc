package org.cw.midc.dao.oauth;

import org.cw.midc.model.oauth.OauthAccessToken;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
