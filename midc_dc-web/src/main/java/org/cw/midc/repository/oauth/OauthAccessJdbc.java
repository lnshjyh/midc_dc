package org.cw.midc.repository.oauth;

import org.cw.midc.model.oauth.OauthAccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OauthAccessJdbc {

	@Autowired
    protected JdbcTemplate jdbcTemplate;
	
	public OauthAccessToken get(String token) {
        return jdbcTemplate.queryForObject("select * from oauth_access_token where access_token = ?",createMapper(),token);
    }
	
	private RowMapper<OauthAccessToken> createMapper() {
      return BeanPropertyRowMapper.newInstance(OauthAccessToken.class);
  }
}
