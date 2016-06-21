package de.java2enterprise.onlineshop;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineshopListener
 *
 */
@WebListener
public class OnlineshopListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public OnlineshopListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
         HttpSession session = event.getSession();
         ServletContext servletcontext = session.getServletContext();
         servletcontext.log("SESSION CREATED: "+event.toString());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
         HttpSession session = event.getSession();
         ServletContext servletcontext = session.getServletContext();
         servletcontext.log("SESSION DESTROYED: "+event.toString());
    }
	
}
