package org.cw.midc.shiro;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.crazycake.shiro.SerializeUtils;
import org.cw.midc.dao.DBSessionDao;
import org.cw.midc.entity.DBSession;
import org.cw.midc.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class DBSessionManageDao extends AbstractSessionDAO {
	
	private static Logger logger = LoggerFactory.getLogger(DBSessionManageDao.class);
	
	@Resource
	private DBSessionDao dbSessionDao;

	@Override
	public void update(Session session) throws UnknownSessionException {
		if(session == null || session.getId() == null){  
            logger.error("session or session id is null");  
            return;  
        }  
          
        String id = session.getId().toString();  
        DBSession dbs = new DBSession(); 
        dbs.setSessionid(id);
        dbs.setSession(SerializeUtils.serialize(session));
        dbSessionDao.update(dbs);
        session.setTimeout(1800000);    

	}

	@Override
	public void delete(Session session) {
		String id = session.getId().toString(); 

        dbSessionDao.delete("deleteBySessionid", id);
	}

	@Override
	public Collection<Session> getActiveSessions() {
		Set<Session> sessions = new HashSet<Session>();  
		List<DBSession> list = dbSessionDao.find("getDBSessionList");
		if(list == null){
			return null;
		}
		Iterator<DBSession> it = list.iterator();
		while(it.hasNext()) {
			DBSession dbs = (DBSession)it.next();
			Session session = (Session)SerializeUtils.deserialize(dbs.getSession());
			sessions.add(session);
		}
		return sessions;
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = this.generateSessionId(session);    
        this.assignSessionId(session, sessionId); 
		String id = sessionId.toString();  
        DBSession dbs = new DBSession(); 
        dbs.setSessionid(id);
        dbs.setSession(SerializeUtils.serialize(session));
        dbSessionDao.save("add",dbs);
		return session.getId();
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		DBSession dbs = dbSessionDao.findUnique("getDBSessionById", sessionId.toString());
		if(dbs == null){
			return null;
		}
		Session session = (Session)SerializeUtils.deserialize(dbs.getSession());
		return session;
	}

}
