package com.jiuling.web.dwr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

import com.jiuling.web.model.SysUser;

/**
 * Created by wangmm on 2016/4/21.
 */
@RemoteProxy(name = "pushMsg")
public class PushMsg {

    @RemoteMethod
    public void onPageLoad(String userid) {
        ScriptSession scriptSession = WebContextFactory.get().getScriptSession();

        scriptSession.setAttribute("userId", userid);
        DwrScriptSessionManagerUtil dwrScriptSessionManagerUtil = new DwrScriptSessionManagerUtil();

        try {

            dwrScriptSessionManagerUtil.init();

            // 新登录的用户添加到用户列表中
            Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
                public boolean match(ScriptSession session) {
                    return true;
                }
            }, new Runnable() {

                private ScriptBuffer script = new ScriptBuffer();

                public void run() {
                    SysUser user1 = new SysUser();
                    user1.setUserId(367L);
                    user1.setRealName("刘娟");
                    //user1.setIsDeptAdmin(0);
                    SysUser user2 = new SysUser();
                    user2.setUserId(368L);
                    user2.setRealName("石秀亭");
                    //user2.setIsDeptAdmin(0);
                    SysUser user3 = new SysUser();
                    user3.setUserId(1L);
                    user3.setRealName("系统管理员");
                    //user3.setIsDeptAdmin(0);
                    List<SysUser> users = new ArrayList<SysUser>();
                    users.add(user1);
                    users.add(user2);
                    users.add(user3);

                    // SysUser user = ContxtUtils.getUserSession();
                    //script.appendCall("addUser", users);

                    Collection<ScriptSession> sessions = Browser.getTargetSessions();

                    for (ScriptSession scriptSession : sessions) {
                        scriptSession.addScript(script);
                    }
                }
            });
        } catch (ServletException e) {

            e.printStackTrace();

        }
    }

    @RemoteMethod
    public void queryMission(String userid) {
        DwrScriptSessionManagerUtil dwrScriptSessionManagerUtil = new DwrScriptSessionManagerUtil();
        try {

            dwrScriptSessionManagerUtil.init();
        } catch (ServletException e) {

            e.printStackTrace();

        }
    }
}
