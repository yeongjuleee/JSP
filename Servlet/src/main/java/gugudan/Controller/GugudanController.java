package gugudan.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gugudan.model.GugudanService;

@WebServlet("/gugudan/GugudanController")
public class GugudanController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int n1 = Integer.parseInt(req.getParameter("n1"));
		
		for(int i = 1; i < 10; i++) {
			System.out.println(n1 + "X" + i + "=" + (n1 * i));
		}
		
		// 한글의 정상적인 출력을 위해 charset 설정
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.append("<html><body><h2>구구단 서블릿</h2><hr>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
/*
	GugudanService service;
	
	public GugudanController() {
		service = new GugudanService();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클라이언트 요청을 구분하고 처리 메소드를 호출한 다음, 뒤로 이동하는 구조를 작성
		String action = req.getParameter("action");
		String view = "";
		//System.out.println(action);
		if(action == null) {
			getServletContext().getRequestDispatcher("/gugudan/GugudanController?action=list").forward(req, resp);
		}
	}
	
*/
	
	
}
