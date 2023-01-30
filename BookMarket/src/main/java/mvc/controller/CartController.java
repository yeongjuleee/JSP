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
// ������������ ��ٱ��Ͽ� ��� ���� : addCart 
// ��ٱ��ϸ� ���� ���� : cart

public class CartController extends HttpServlet {
	// CartController�� �������� �˷��� => extends HttpServlet

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String RequestURI = req.getRequestURI();	//��ü ��� ��������
		String contextPath = req.getContextPath();	//������Ʈ�� path�� ��������
		String command = RequestURI.substring(contextPath.length());
		 
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		System.out.println("cart command : " + command);
		
		if (command.contains("addCart.jsp")) { // ��ٱ��� ��� : ���ڿ�(command)�� addCart�� ���ԵǾ� �ִ�
			// �Ķ���ͷ� �Ѿ�� ���̵� ���� Ȯ�� > ��ٱ��� db�� ������ ��
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
			
			HttpSession session = req.getSession();	// ���� ����� ���Ͽ� ���� �� ����
			
			String orderNum = session.getId(); 
			String sessionId = (String)session.getAttribute("sessionId");
			
			CartDAO cartDAO = new CartDAO();
			
			boolean flag = cartDAO.updateCart(bookDTO, orderNum, sessionId);
			
			resp.sendRedirect("product.jsp?id=" + id);
		}
		else if (command.contains("cart.jsp")) {
			CartDAO cartDAO = new CartDAO();
			
			HttpSession session = req.getSession();	// ���� ����� ���� ���� �� ������ ��
			String orderNo = session.getId();

			ArrayList<CartDTO> cartArrayList = cartDAO.getCartList(orderNo);
			req.setAttribute("cartArrayList", cartArrayList);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/web_jsp/03_action/market/shop_db/_cart.jsp");
			requestDispatcher.forward(req, resp);
		}
	} // doPost �ݱ�
} // Controller �ݱ�