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
         // ���ؽ�Ʈ�� ������ �� �ڵ����� ȣ���� �޼ҵ�
    	System.out.println("TestContextListener ����Ǿ����ϴ�.");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // ���ؽ�Ʈ�� �ʱ�ȭ�� �� �ڵ����� ȣ��Ǵ� �޼ҵ�
    	ServletContext ctx = sce.getServletContext();
    	Book mybook = new Book("��´�", "�̿���", 790, "�ȳ�");
    	ctx.setAttribute("book", mybook);
    	System.out.print("TestContextListener �ʱ�ȭ �Ǿ����ϴ�.");
    }
	
}
