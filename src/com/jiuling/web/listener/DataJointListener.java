package com.jiuling.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.loocme.plugin.spring.Config;
import com.loocme.plugin.spring.dao.SpringJdbcDao;

/**
 * Application Lifecycle Listener implementation class DataJointListener
 *
 */
public class DataJointListener implements ServletContextListener
{

    /**
     * Default constructor.
     */
    public DataJointListener()
    {
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)
    {
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)
    {
        // 启动loocme orm framework
        WebApplicationContext applicationCxt = WebApplicationContextUtils
                .getWebApplicationContext(event.getServletContext());
        new Config(applicationCxt).create("dataSource");
        SpringJdbcDao.debug = true;
    }

}
