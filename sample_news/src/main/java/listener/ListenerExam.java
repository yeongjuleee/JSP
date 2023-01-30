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
	// Listener ���� �����ϴ� �׸� : � ���� ����(���)���� ���ϴ� ��
	
	
    /**
     * Default constructor. 
     */
    public ListenerExam() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    // ServletContext ����
    public void contextInitialized(ServletContextEvent sce)  { 
    	sce.getServletContext().log("ServletContext ���� ��!");
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    // ServletContext�� �Ӽ� �߰�
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         // �Ӽ��� �߰��� �� �߰��� ������ ���
    	scae.getServletContext().log("ServletContext �Ӽ� �߰� : " + scae.getValue());
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    // ServletContext �Ӽ� ����
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }
    
	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    // ServletContext �Ӽ� ����
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }    
    
    /*
    @see ServletContextListener#contextDestroyed(ServletContextEvent)
    */
   // ServletContext ����
   public void contextDestroyed(ServletContextEvent sce)  { 
   	sce.getServletContext().log("ServletContext ���� ��!");
   }
    
	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // ���� ����
    	se.getSession().getServletContext().log("Session ���� �� : " + se.getSession().getId());
    }

    // @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         // ���� �Ӽ� �߰�
    	se.getSession().getServletContext().log("Session �Ӽ� �߰� : " + se.getValue());
    }
    
    // @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // ���� �Ӽ� ����
    }

    //@see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // ���� �Ӽ� ����
    }
    
    //@see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // ���� ����
    }
}
