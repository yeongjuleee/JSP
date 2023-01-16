package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dao.AddressBookDAO;
import mvc.dto.AddressBookDTO;

@WebServlet("*.do")

public class Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		String action = req.getParameter("action");
		System.out.println(action);
		
		AddressBookDAO dao = new AddressBookDAO();
		AddressBookDTO addressBookDTO = new AddressBookDTO();
		
		// �Ķ���Ϳ� ���� ��û ó��
		// �ּҷ� ��� ��û�� ���
		if (action.equals("list")) {
			ArrayList<AddressBookDTO> datas = dao.getDBList();
			req.setAttribute("datas", datas);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("address_book_list.jsp");
			requestDispatcher.forward(req, resp);
		}
		
		// �ּҷ� ��� ��û�� ���
		else if (action.equals("insert")) {
			System.out.println(req.getParameter("name"));
			System.out.println(req.getParameter("comdept"));
			addressBookDTO.setName(req.getParameter("name"));
			addressBookDTO.setEmail(req.getParameter("email"));
			addressBookDTO.setTel(req.getParameter("tel"));
			addressBookDTO.setBirth(req.getParameter("birth"));
			addressBookDTO.setComdept(req.getParameter("comdept"));
			addressBookDTO.setMemo(req.getParameter("memo"));
			
			if(dao.insertDB(addressBookDTO)) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("control.do?action=list");
				requestDispatcher.forward(req, resp);
			}
			else {
				try {
					throw new Exception ("DB �Է� ����");
				} catch (Exception ignored) {
					
				}
			}
		}
		
		// �ּҷ� ���� ������ ��û�� ���
		else if(action.equals("edit")) {
			if(!req.getParameter("passwd").equals("1234")) {
				String resStr = "<script>alert('��й�ȣ�� Ʋ�Ƚ��ϴ�!!'); history.go(-1); </script>";
				resp.getWriter().print(resStr);	// ���� �������� ����
			}
			else {
				AddressBookDTO dto = dao.getDB(Integer.parseInt(req.getParameter("id")));
				req.setAttribute("dto", dto);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("address_book_edit_form.jsp");
				requestDispatcher.forward(req, resp);
			}
		}
		
		// �ּҷ� ���� ��� ��û�� ���
		else if (action.equals("update")) {
			System.out.println(req.getParameter("name"));
			System.out.println(req.getParameter("comdept"));
			
			addressBookDTO.setId(Integer.parseInt(req.getParameter("id")));
			addressBookDTO.setName(req.getParameter("name"));
			addressBookDTO.setEmail(req.getParameter("email"));
			addressBookDTO.setTel(req.getParameter("tel"));
			addressBookDTO.setBirth(req.getParameter("birth"));
			addressBookDTO.setComdept(req.getParameter("comdept"));
			addressBookDTO.setMemo(req.getParameter("memo"));
			
			if (dao.updateDB(addressBookDTO)) {
				resp.sendRedirect("address_book_control.jsp?action=list");
			}
			else {
				try {
					throw new Exception("DB ���� ����");
				} catch (Exception ignored) {
					
				}
			}
		}
	
	} // doPost ��
} // Class ��
