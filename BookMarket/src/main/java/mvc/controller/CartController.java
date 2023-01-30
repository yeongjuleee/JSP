package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookstore.dao.CartDAO;
import bookstore.dao.BookDAO;
import bookstore.dto.CartDTO;
import bookstore.dto.Book;

@WebServlet(urlPatterns = {"/web_jsp/03_action/market/shop_db/addCart.jsp", "/web_jsp/03_action/market/shop_db/cart.jsp"})
// 상세페이지에서 장바구니에 담는 동작 : addCart 
// 장바구니를 보는 동작 : cart

public class CartController extends HttpServlet {
	// CartController는 서블릿임을 알려줌 => extends HttpServlet

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String RequestURI = req.getRequestURI();	//전체 경로 가져오기
		String contextPath = req.getContextPath();	//프로젝트의 path만 가져오기
		String command = RequestURI.substring(contextPath.length());
		 
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		System.out.println("cart command : " + command);
		
		if (command.contains("addCart.jsp")) { // 장바구니 담기 : 문자열(command)의 addCart에 포함되어 있는
			// 파라미터로 넘어온 아이디 값을 확인 > 장바구니 db에 넣으면 됨
			String id = req.getParameter("id");
			if (id == null || id.trim().equals("")) {
				resp.sendRedirect("products.jsp");
				return;
			}
			
			BookDAO productDAO = new BookDAO();
			
			Book bookDTO = productDAO.getBookById(id);
			if (bookDTO == null) {
				resp.sendRedirect("../exception/exeptionNoProductId.jsp");
			}
			
			HttpSession session = req.getSession();	// 세션 사용을 위하여 세션 값 생성
			
			String orderNum = session.getId(); 
			String sessionId = (String)session.getAttribute("sessionId");
			
			CartDAO cartDAO = new CartDAO();
			
			boolean flag = cartDAO.updateCart(bookDTO, orderNum, sessionId);
			
			resp.sendRedirect("product.jsp?id=" + id);
		}
		else if (command.contains("cart.jsp")) {
			CartDAO cartDAO = new CartDAO();
			
			HttpSession session = req.getSession();	// 세션 사용을 위해 세션 값 생성을 함
			String orderNo = session.getId();

			ArrayList<CartDTO> cartArrayList = cartDAO.getCartList(orderNo);
			req.setAttribute("cartArrayList", cartArrayList);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/web_jsp/03_action/market/shop_db/_cart.jsp");
			requestDispatcher.forward(req, resp);
		}
	} // doPost 닫기
} // Controller 닫기