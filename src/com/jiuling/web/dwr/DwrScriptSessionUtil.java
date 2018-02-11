package com.jiuling.web.dwr;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.impl.DefaultScriptSession;
import org.directwebremoting.impl.DefaultScriptSessionManager;

import com.jiuling.web.model.SysUser;

public class DwrScriptSessionUtil extends DefaultScriptSessionManager {
    public static final String SS_ID = "DWR_ScriptSession_Id";

    public DwrScriptSessionUtil() {
        try {
            addScriptSessionListener(new ScriptSessionListener() {

                public void sessionDestroyed(ScriptSessionEvent event) {

                }

                public void sessionCreated(ScriptSessionEvent event) {
                    ScriptSession scriptSession = event.getSession();// 得到新创建的scriptSession
                    HttpSession httpSession = WebContextFactory.get().getSession();// 得到产生的httpSession
                    SysUser user = (SysUser) httpSession.getAttribute("userInfo");// 得到当前用户
                    // 如果当前用户已经退出系统，然后销毁这个scriptsession
                    if (user == null) {
                        scriptSession.invalidate();
                        httpSession.invalidate();
                        return;
                    }
                    String ssId = (String) httpSession.getAttribute(SS_ID);// 查找SS_ID
                    if (ssId != null) {
                        // 说明已经存在旧的scriptSession.注销这个旧的scriptSession
                        DefaultScriptSession oldScriptSession = sessionMap.get(ssId);
                        if (oldScriptSession != null) {
                            invalidate(oldScriptSession);
                        }
                    }
                    httpSession.setAttribute(SS_ID, scriptSession.getId());
                    scriptSession.setAttribute("userId", user.getUserId());// 绑定用户ID到ScriptSession上
                }
            });
        } catch (Exception e) {
            //System.out.println("zhelichucuo");
            e.printStackTrace();
        }
    }

    public static void invalidate(String ssId) {
        Browser.withSession(ssId, new Runnable() {

            public void run() {
                Collection<ScriptSession> sessions = Browser.getTargetSessions();
                for (ScriptSession session : sessions) {
                    session.invalidate();
                }
            }
        });
    }

}