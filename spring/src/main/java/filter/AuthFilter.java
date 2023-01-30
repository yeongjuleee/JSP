package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import java.io.PrintWriter;

//@WebFilter("*.jsp")
public class AuthFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// ���� �ʱ�ȭ
		System.out.println("Filter01 init...");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// ���͸� ���ҽ��� ����
		System.out.println("Filter01.jsp ����...");
		String name = req.getParameter("name");	// ������������ ���۵� ��û �Ķ���͸� ����
		
		if(name == null || name.equals("")) {
			// �� ���������� ���۵� ��û �Ķ���Ͱ� ������ ���� �������� ����
			// chain.doFilter()�� �����ϱ� ���� ����
			// ���� �� �������� �޽����� ����ϵ��� ���� �� �������� ���� ���� ���ڵ�, ������ ����, �޽��� �ۼ�
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter printWriter = resp.getWriter();
			String message = "�Էµ� name ���� null �Դϴ�.";
			printWriter.println(message);
			return;
		}
		// ���������� ���Ͱ� ������ ���� ���ͷ� ��� �ѱ⵵�� FilterChain ��ü Ÿ���� doFilter() �޼ҵ带 �ۼ�
		chain.doFilter(req, resp);
		
	}
	
	@Override
	public void destroy() {
		// ���� ���� ���� ȣ���
		System.out.println("Filter01.jsp clear...");
	}

}
