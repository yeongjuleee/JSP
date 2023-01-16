package helloWorld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 현재 클래스가 서블릿 클래스라는 것을 컨테이너에 알리기 위해 어노테이션을 사용
// 어떤 요청에 의해 서블릿을 호출할 것인지 결정하는 URL mapping 부분도 urlPatterns 속성으로 지정
// @WebServlet("/hello") 길이 단수화하는 것도 가능

@WebServlet(description = "My first servlet", urlPatterns = {"/hello"})
public class HelloWorld extends HttpServlet {

	@Override
	// GET 요청을 처리하는 메소드. request, response를 인자로 함
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 응답 콘텐츠 타입 설정과 한글 출력을 위해 response.setContentType() 메소드 사용
		resp.setContentType("text/html; charset=utf-8");
		// PrintWriter는 출력 스트림으로 클라이언트에 전달할 출력문 작성에 사용
		// 출력 스트림을 이용해 HTML 형식으로 데이터와 결합해 출력
		PrintWriter out = resp.getWriter();
		out.append("<!doctype html><html><head><title>Hello World Servlet</title></head><body>")
		.append("<h2>Hello World !! </h2><hr>")
		.append("현재 날짜와 시간은 : " + java.time.LocalDateTime.now())
		.append("</body></html>");
	}

	@Override
	// POST 요청을 처리하는 메소드
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// REST API 구현이 아닌 일반 서블릿 구현이라면 GET, POST를 내부적으로 동일하게 처리
		doGet(req, resp);
	}
	
	
}
