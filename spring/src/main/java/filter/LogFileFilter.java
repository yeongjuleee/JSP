package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogFileFilter implements Filter {
	PrintWriter printWriter;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// ���� �ʱ�ȭ
		// web.xml ������ <init-param> ��ҿ� ������ �Ű����� fileName ���� ���޹޵���
		// fileConfig ��ü�� getInitParameter() �޼ҵ� �ۼ�
		
		String fileName = filterConfig.getInitParameter("fileName");
		if (fileName == null) {
			throw new ServletException ("�α� ������ �̸��� ã�� �� �����ϴ�.");
		}
		
		try {
			printWriter = new PrintWriter(new FileWriter(fileName, true), true);
		} catch (IOException e) {
			throw new ServletException("�α� ������ �� �� �����ϴ�.");
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// ���͸� ���ҽ��� �����ϵ��� doFiter) �޼ҵ� �ۼ�
		// ���� �Ͻø� ����ϵ��� ����� ���� �޼ҵ��� getCurrentTime()�� ȣ��
		printWriter.println("���� �Ͻ� : " + getCurrentTime());
		String clienAddr = req.getRemoteAddr();	// Ŭ���̾�Ʈ�� �ּҸ� ���
		printWriter.println("Ŭ���̾�Ʈ �ּ� : " + clienAddr);
		
		chain.doFilter(req, resp);
		
		String contentType = resp.getContentType();
		printWriter.println("������ ������ ���� : " + contentType);
		printWriter.println("---------------------------------------");
	}

	@Override
	public void destroy() {
		// ���Ͱ� �����ϱ� ���� ȣ���ϵ��� destroy() �޼ҵ� �ۼ�
		printWriter.close();
	}
	
	private String getCurrentTime() {
		// ������ �ð��� ������ ����� ���� �޼ҵ�
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return dateFormat.format(calendar.getTime());
	}
	
	
}
