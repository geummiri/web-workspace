package servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class MyServletListener
 *
 */
public class MyServletListener implements ServletContextListener {

	private ServletContext context;
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("contextDestroyed...");
    	
    }
    
    //dd(web.xml) - ServletContext 생성 - ServletContextEvent 발생 - 리스너 감지 - 호출
    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("contextInitialized...");
    	//sce에서 ServletContext 를 받아온다.
    	
    	context = sce.getServletContext();
    	context.setAttribute("context","contextData...01");
    	
    }
    
    
	
}
