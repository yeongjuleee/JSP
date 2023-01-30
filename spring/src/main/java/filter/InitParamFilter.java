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
		// 필터 초기화
		System.out.println("Filter02 init...");
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// 필터를 리소스에 적용
		System.out.println("Filter02 process...");
		// 폼 페이지에서 전송된 요청 파라미터인 아이디와 비밀번호를 전달
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		// web.xml 파일의 <init-param>요소에 설정된 매개 변수 param1, param2를 전달받도록
		// FilterConfig.getInitParameter() 메소드 작성
		String param1 = filterConfig.getInitParameter("param1");
		String param2 = filterConfig.getInitParameter("param2");
		
		String message;
		
		// 응답 웹 페이지에 대한 문자 인코딩, 콘텐츠 유형을 설정하도록 response 내장 객체의 메소드 작성
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter printWriter = resp.getWriter();
		
		// 폼 페이지에서 전송된 요청 파라미터와 web.xml 파일에 설정된 매개 변수의 값을 비교하여 메시지 출력
		if (id.equals(param1) && passwd.equals(param2)) {
			message = "로그인에 성공했습니다.";
		}
		else {
			message = "로그인에 실패해습니다.";
		}
		printWriter.println(message);
		
		// 연속적으로 필터가 있으면 다음 필터로 제어를 넘김
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		// 필터가 종료하기 전에 호출
		System.out.println("Filter02 clear...");
	}
	
	
}
