package gugudan.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gugudan.model.Gugudan;


@WebServlet("/gugudan/GugudanController")
// @WebServlet("��Ű����/Ŭ������")
public class GugudanController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gugudan gu = new Gugudan();
		int n = Integer.parseInt(req.getParameter("n"));
		int[] result = gu.gugu(n); // Gugu �޼ҵ��� ��� ���� result�� ���� 
		for(int i = 0; i < 9; i++) {
			req.setAttribute("result", result);
		}
		getServletContext().getRequestDispatcher("/gugudan/result.jsp").forward(req, resp);
		// getSerlvetContext().getRequestDispatcher("/������/jsp���ϸ�.jsp").forward(req,resp);
	}

}
