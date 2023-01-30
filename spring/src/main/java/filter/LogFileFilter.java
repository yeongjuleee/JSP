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
		// 필터 초기화
		// web.xml 파일의 <init-param> 요소에 설정된 매개변수 fileName 값을 전달받도록
		// fileConfig 객체의 getInitParameter() 메소드 작성
		
		String fileName = filterConfig.getInitParameter("fileName");
		if (fileName == null) {
			throw new ServletException ("로그 파일의 이름을 찾을 수 없습니다.");
		}
		
		try {
			printWriter = new PrintWriter(new FileWriter(fileName, true), true);
		} catch (IOException e) {
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// 필터를 리소스에 적용하도록 doFiter) 메소드 작성
		// 현재 일시를 출력하도록 사용자 정의 메소드인 getCurrentTime()을 호출
		printWriter.println("현재 일시 : " + getCurrentTime());
		String clienAddr = req.getRemoteAddr();	// 클라이언트의 주소를 출력
		printWriter.println("클라이언트 주소 : " + clienAddr);
		
		chain.doFilter(req, resp);
		
		String contentType = resp.getContentType();
		printWriter.println("문서의 컨텐츠 유형 : " + contentType);
		printWriter.println("---------------------------------------");
	}

	@Override
	public void destroy() {
		// 필터가 종료하기 전에 호출하도록 destroy() 메소드 작성
		printWriter.close();
	}
	
	private String getCurrentTime() {
		// 현재의 시간을 얻어오는 사용자 정의 메소드
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return dateFormat.format(calendar.getTime());
	}
	
	
}
