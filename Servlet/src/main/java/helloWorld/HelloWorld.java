package helloWorld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ���� Ŭ������ ���� Ŭ������� ���� �����̳ʿ� �˸��� ���� ������̼��� ���
// � ��û�� ���� ������ ȣ���� ������ �����ϴ� URL mapping �κе� urlPatterns �Ӽ����� ����
// @WebServlet("/hello") ���� �ܼ�ȭ�ϴ� �͵� ����

@WebServlet(description = "My first servlet", urlPatterns = {"/hello"})
public class HelloWorld extends HttpServlet {

	@Override
	// GET ��û�� ó���ϴ� �޼ҵ�. request, response�� ���ڷ� ��
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���� ������ Ÿ�� ������ �ѱ� ����� ���� response.setContentType() �޼ҵ� ���
		resp.setContentType("text/html; charset=utf-8");
		// PrintWriter�� ��� ��Ʈ������ Ŭ���̾�Ʈ�� ������ ��¹� �ۼ��� ���
		// ��� ��Ʈ���� �̿��� HTML �������� �����Ϳ� ������ ���
		PrintWriter out = resp.getWriter();
		out.append("<!doctype html><html><head><title>Hello World Servlet</title></head><body>")
		.append("<h2>Hello World !! </h2><hr>")
		.append("���� ��¥�� �ð��� : " + java.time.LocalDateTime.now())
		.append("</body></html>");
	}

	@Override
	// POST ��û�� ó���ϴ� �޼ҵ�
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// REST API ������ �ƴ� �Ϲ� ���� �����̶�� GET, POST�� ���������� �����ϰ� ó��
		doGet(req, resp);
	}
	
	
}
