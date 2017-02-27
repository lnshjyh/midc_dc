package org.cw.midc.service;

import org.cw.midc.entity.User;

public interface LoginService {

	User doLogin(String account, String clientIp);
	
}
