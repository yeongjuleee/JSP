package calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.cal")
public class CalcServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HTML <form>에서 입력한 파라미터는 Query String으로 서블릿에 전달되며
		// doGet() 메소드의 인자인 request의 getParameter()를 통해 참조
		// req.getParameter()는 리턴값이 문자열이므로 연산을 위해서는 다시 숫자로 변환하는 과정이 필요
		
		int n1 = Integer.parseInt(req.getParameter("n1"));
		int n2 = Integer.parseInt(req.getParameter("n2"));
		String op = req.getParameter("op");
		
		long result = 0; // 연산의 결과 값을 저장
		
		switch (op) {
			case "+" :
				result = n1 + n2;
				break;
				
			case "-" :
				result = n1 - n2;
				break;
				
			case "*" :
				result = n1 * n2;
				break;
				
			case "/" :
				result = n1 / n2;
				break;
		}
		
		// 한글의 정상적인 출력을 위해 charset 설정
		resp.setContentType("text/html; charset=utf-8");
		// 결과 화면을 출력 스트림을 통해 출력
		PrintWriter out = resp.getWriter();
		out.append("<html><body><h2>계산기 서블릿</h2><hr>");
		out.append("계산 결과 : " + result + "</body></html>");
	}

}
