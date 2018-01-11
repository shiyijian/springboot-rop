package com.rop.session;

/**
 * 会话管理器
 *
 * @author libinsong@gmail.com
 * @author 陈雄华
 */
public interface SessionManager {

    /**
     * 存储接口的session
     *
     * @param sessionId
     */
    void setSession(String sessionId);

    /**
     * 注册一个会话
     *
     * @param session
     */
    void addSession(String sessionId, Session session);

    /**
     * 从注册表中获取会话
     *
     * @param sessionId
     * @return
     */
    Session getSession(String sessionId);

    /**
     * 移除这个会话
     *
     * @param sessionId
     * @return
     */
    void removeSession(String sessionId);

    /**
     * 判断是否存在session
     * @param sessionId
     * @return
     */
    boolean hasSession(String sessionId);
}

