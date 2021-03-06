package com.jiuling.web.dwr;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.directwebremoting.Container;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;
import org.directwebremoting.servlet.DwrServlet;

import com.jiuling.core.util.ContxtUtils;
import com.jiuling.web.model.SysUser;

/**
 * Created by wangmm on 2016/4/21.
 */
public class DwrScriptSessionManagerUtil extends DwrServlet {
    private static final long serialVersionUID = -7504612622407420071L;

    public void init() throws ServletException {

        Container container = ServerContextFactory.get().getContainer();
        ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
        ScriptSessionListener listener = new ScriptSessionListener() {
            @SuppressWarnings("unused")
            public void sessionCreated(ScriptSessionEvent ev) {
                HttpSession session = WebContextFactory.get().getSession();
                String userId = (String) session.getAttribute("userId");
                SysUser user = ContxtUtils.getUserSession();
                // //System.out.println(userId+" ScriptSession is created!");
                ev.getSession().setAttribute("userId", user.getUserId() + "");
            }

            public void sessionDestroyed(ScriptSessionEvent ev) {
                // //System.out.println("a ScriptSession is distroyed");
            }
        };
        manager.addScriptSessionListener(listener);
    }
}
