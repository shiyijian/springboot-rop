package com.web.ropboot.manager;

import com.google.common.collect.Maps;
import com.rop.session.Session;
import com.rop.session.SessionManager;
import com.rop.session.SimpleSession;
import com.web.ropboot.service.InitalService;
import com.web.ropboot.utils.JedisUtil;
import com.web.ropboot.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class SimpleSessionManager implements SessionManager{

    private static final Logger log = LoggerFactory.getLogger(SimpleSessionManager.class);

    @Value("${server.env}")
    private String serverEnv;

    private Map<String,Session> sessionMap = Maps.newConcurrentMap();

    /**
     * 存储接口的session，5分钟超时
     * @param sessionId
     */
    public void setSession(String sessionId){

        Session session = new SimpleSession();

        if(serverEnv.equals("local")) {
            sessionMap.put(sessionId,session);
        }else if(serverEnv.equals("online")){
            Jedis jedis = null;
            try {
                jedis = JedisUtil.getJedis();
                jedis.set(sessionId, JsonUtil.toJson(session));
                jedis.expire(sessionId,5*60);
            }finally {
                JedisUtil.returnResource(jedis);
            }
        }
    }

    /**
     * 存储登录的session,5天超时
     * @param sessionId
     * @param session
     */
    @Override
    public void addSession(String sessionId, Session session) {
        if(serverEnv.equals("local")) {
            sessionMap.put(sessionId, session);
        }else if(serverEnv.equals("online")){
            Jedis jedis = null;
            try {
                jedis = JedisUtil.getJedis();
                jedis.set(sessionId, JsonUtil.toJson(session));

                jedis.expire(sessionId,5*24*60*60);
            }finally {
                JedisUtil.returnResource(jedis);
            }
        }
    }

    @Override
    public Session getSession(String sessionId) {
        if(serverEnv.equals("local")) {
            return sessionMap.get(sessionId);
        }else if(serverEnv.equals("online")){
            Jedis jedis = null;
            try {
                jedis = JedisUtil.getJedis();
                String json = jedis.get(sessionId);
                return JsonUtil.parseJson(json,SimpleSession.class);
            }finally {
                JedisUtil.returnResource(jedis);
            }
        }
        return sessionMap.get(sessionId);
    }

    @Override
    public void removeSession(String sessionId) {
        if(serverEnv.equals("local")) {
            sessionMap.remove(sessionId);
        }else if(serverEnv.equals("online")){
            Jedis jedis = null;
            try {
                jedis = JedisUtil.getJedis();
                jedis.del(sessionId);
            }finally {
                JedisUtil.returnResource(jedis);
            }
        }
    }

    @Override
    public boolean hasSession(String sessionId) {
        if(serverEnv.equals("local")) {
            return sessionMap.containsKey(sessionId);
        }else if(serverEnv.equals("online")){
            Jedis jedis = null;
            try {
                jedis = JedisUtil.getJedis();
                return jedis.exists(sessionId);
            }finally {
                JedisUtil.returnResource(jedis);
            }
        }
        return false;
    }
}
