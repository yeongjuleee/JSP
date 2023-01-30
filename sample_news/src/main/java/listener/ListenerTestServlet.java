package listener;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Servlet implementtation class ListenerTestServlet

@WebServlet("/ListenerTestServlet")
public class ListenerTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletContext sc;
	
	// @see HttpServlet#HttpServlet()
	
	public ListenerTestServlet() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		sc = getServletContext();
	}
	
	// @see HttpServlet#doGet(HttpServletReqeust req, HttpServletResponse resp)
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sc.setAttribute("name", "辫霖痹");
		
		HttpSession session = req.getSession();
		session.setAttribute("ssName", session.getId() + ": 技记 加己 历厘!");
	}
	
}
