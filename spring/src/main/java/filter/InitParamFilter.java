package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class InitParamFilter implements Filter {
	private FilterConfig filterConfig = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// ���� �ʱ�ȭ
		System.out.println("Filter02 init...");
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// ���͸� ���ҽ��� ����
		System.out.println("Filter02 process...");
		// �� ���������� ���۵� ��û �Ķ������ ���̵�� ��й�ȣ�� ����
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		// web.xml ������ <init-param>��ҿ� ������ �Ű� ���� param1, param2�� ���޹޵���
		// FilterConfig.getInitParameter() �޼ҵ� �ۼ�
		String param1 = filterConfig.getInitParameter("param1");
		String param2 = filterConfig.getInitParameter("param2");
		
		String message;
		
		// ���� �� �������� ���� ���� ���ڵ�, ������ ������ �����ϵ��� response ���� ��ü�� �޼ҵ� �ۼ�
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter printWriter = resp.getWriter();
		
		// �� ���������� ���۵� ��û �Ķ���Ϳ� web.xml ���Ͽ� ������ �Ű� ������ ���� ���Ͽ� �޽��� ���
		if (id.equals(param1) && passwd.equals(param2)) {
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
		System.out.println("Filter02 clear...");
	}
	
	
}
