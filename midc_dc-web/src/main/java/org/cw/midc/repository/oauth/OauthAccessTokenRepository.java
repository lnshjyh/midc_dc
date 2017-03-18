package org.cw.midc.repository.oauth;

import java.util.List;

import org.cw.midc.model.oauth.OauthAccessToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthAccessTokenRepository extends PagingAndSortingRepository<OauthAccessToken, String> {

	
}
