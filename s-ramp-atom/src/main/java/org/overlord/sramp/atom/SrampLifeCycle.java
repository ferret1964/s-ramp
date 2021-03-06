package org.overlord.sramp.atom;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.overlord.sramp.repository.PersistenceFactory;

/**
 * Listener for deploy/undeploy events.
 */
public class SrampLifeCycle implements ServletContextListener {

	/**
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    /**
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        PersistenceFactory.newInstance().shutdown();
    }

}
