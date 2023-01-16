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
		// HTML <form>���� �Է��� �Ķ���ʹ� Query String���� ������ ���޵Ǹ�
		// doGet() �޼ҵ��� ������ request�� getParameter()�� ���� ����
		// req.getParameter()�� ���ϰ��� ���ڿ��̹Ƿ� ������ ���ؼ��� �ٽ� ���ڷ� ��ȯ�ϴ� ������ �ʿ�
		
		int n1 = Integer.parseInt(req.getParameter("n1"));
		int n2 = Integer.parseInt(req.getParameter("n2"));
		String op = req.getParameter("op");
		
		long result = 0; // ������ ��� ���� ����
		
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
		
		// �ѱ��� �������� ����� ���� charset ����
		resp.setContentType("text/html; charset=utf-8");
		// ��� ȭ���� ��� ��Ʈ���� ���� ���
		PrintWriter out = resp.getWriter();
		out.append("<html><body><h2>���� ����</h2><hr>");
		out.append("��� ��� : " + result + "</body></html>");
	}

}
