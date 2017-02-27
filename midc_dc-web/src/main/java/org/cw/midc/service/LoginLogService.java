package org.cw.midc.service;

import org.cw.midc.ParamFilter;
import org.cw.midc.entity.LoginLog;

import java.util.List;

public interface LoginLogService{

     void add(LoginLog loginLog);

    void delete(String[] loginLogIds);

    List<LoginLog> getList(ParamFilter paramFilter);
}
