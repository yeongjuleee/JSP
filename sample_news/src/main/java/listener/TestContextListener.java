package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TestContextListener
 *
 */
@WebListener
public class TestContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // 컨텍스트를 종료할 때 자동으로 호출디는 메소드
    	System.out.println("TestContextListener 종료되었습니다.");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // 컨텍스트를 초기화할 때 자동으로 호출되는 메소드
    	ServletContext ctx = sce.getServletContext();
    	Book mybook = new Book("잠온다", "이영주", 790, "안녕");
    	ctx.setAttribute("book", mybook);
    	System.out.print("TestContextListener 초기화 되었습니다.");
    }
	
}
