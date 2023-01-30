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
		// 필터 초기화
		System.out.println("Filter01 init...");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// 필터를 리소스에 적용
		System.out.println("Filter01.jsp 수행...");
		String name = req.getParameter("name");	// 폼페이지에서 전송된 요청 파라미터를 전달
		
		if(name == null || name.equals("")) {
			// 폼 페이지에서 전송된 요청 파라미터가 없으면 응답 페이지를 전송
			// chain.doFilter()를 실행하기 전에 종료
			// 응답 웹 페이지에 메시지를 출력하도록 응답 웹 페이지에 대한 문자 인코딩, 콘텐츠 유형, 메시지 작성
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter printWriter = resp.getWriter();
			String message = "입력된 name 값은 null 입니다.";
			printWriter.println(message);
			return;
		}
		// 연속적으로 필터가 있으면 다음 필터로 제어를 넘기도록 FilterChain 객체 타입의 doFilter() 메소드를 작성
		chain.doFilter(req, resp);
		
	}
	
	@Override
	public void destroy() {
		// 필터 종료 전에 호출됨
		System.out.println("Filter01.jsp clear...");
	}

}
