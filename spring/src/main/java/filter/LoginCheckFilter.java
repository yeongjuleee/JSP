package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckFilter implements Filter{
	private FilterConfig filterConfig = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// ���� �ʱ�ȭ
		System.out.println("loginForm init...");
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// ���͸� ���ҽ��� ����
		System.out.println("loginForm process...");
		// �� ���������� ���۵� ��û �Ķ������ ���̵�� ��й�ȣ�� ����
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		// web.xml ������ <init-param>��ҿ� ������ �Ű� ���� userID, userPW�� ���޹޵���
		// FilterConfig.getInitParameter() �޼ҵ� �ۼ�
		String userId = filterConfig.getInitParameter("userId");
		String userPw = filterConfig.getInitParameter("userPw");
		
		String message;
		
		// ���� �� �������� ���� ���� ���ڵ�, ������ ������ �����ϵ��� response ���� ��ü�� �޼ҵ� �ۼ�
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter printWriter = resp.getWriter();
		
		// �� ���������� ���޵� ���̵� ���� null�̸� loginForm.jsp�� �̵��ϵ��� �ۼ�
		if(id.equals("") || id == null) {
			((HttpServletResponse)resp).sendRedirect("loginForm.jsp?error=1");
//			HttpServletResponse resp = (HttpServletResponse)
		}
		
		// �� ���������� ���۵� ��û �Ķ���Ϳ� web.xml ���Ͽ� ������ �Ű� ������ ���� ���Ͽ� �޽��� ���
		if (id.equals(userId) && passwd.equals(userPw)) {
			message = "�α��ο� �����߽��ϴ�.";
		}
		else {
			message = "�α��ο� �����ؽ��ϴ�.";
		}
		printWriter.println(message);
		
		// ���������� ���Ͱ� ������ ���� ���ͷ� ��� �ѱ�
		chain.doFilter(req, resp);
		
	}

	@Override
	public void destroy() {
		// ���Ͱ� �����ϱ� ���� ȣ��
		System.out.println("loginForm clear...");
	}

	
}
