package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ListenerExam
 *
 */
@WebListener
public class ListenerExam implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {
	// Listener 에서 선택하는 항목 : 어떤 것을 구현(상속)할지 정하는 것
	
	
    /**
     * Default constructor. 
     */
    public ListenerExam() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    // ServletContext 시작
    public void contextInitialized(ServletContextEvent sce)  { 
    	sce.getServletContext().log("ServletContext 시작 됨!");
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    // ServletContext에 속성 추가
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         // 속성이 추가될 때 추가된 내용을 출력
    	scae.getServletContext().log("ServletContext 속성 추가 : " + scae.getValue());
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    // ServletContext 속성 변경
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }
    
	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    // ServletContext 속성 삭제
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }    
    
    /*
    @see ServletContextListener#contextDestroyed(ServletContextEvent)
    */
   // ServletContext 종료
   public void contextDestroyed(ServletContextEvent sce)  { 
   	sce.getServletContext().log("ServletContext 종료 됨!");
   }
    
	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // 세션 생성
    	se.getSession().getServletContext().log("Session 생성 됨 : " + se.getSession().getId());
    }

    // @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         // 세션 속성 추가
    	se.getSession().getServletContext().log("Session 속성 추가 : " + se.getValue());
    }
    
    // @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // 세션 속성 삭제
    }

    //@see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // 세션 속성 변경
    }
    
    //@see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // 세션 종료
    }
}
