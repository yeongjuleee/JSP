package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import mvc.model.BoardDAO;
import mvc.model.BoardDTO;

public class BoardController extends HttpServlet {
	static final int LISTCOUNT = 5;	//������ �� �Խù� ��

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);	//get ������� �Ѿ�� ���� post�� �ѱ�� ��
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String RequestURI = req.getRequestURI();	//��ü ��� ��������
		String contextPath = req.getContextPath();	//������Ʈ�� path�� ��������
		String command = RequestURI.substring(contextPath.length());
		 
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		System.out.println(command);	//����� ��� �߿� �ϳ�. �ؿ� ������ �ɷ� Ȯ��
		
		//url ������ Ȯ���ؼ� /BoardListAction.do �갡 ������ �޼ҵ� ����
		if (command.contains("/BoardListAction.do")) {	//��ϵ� �� ��� ������ ����ϱ�
			requestBoardList(req);	//�޼ҵ� ����
			RequestDispatcher rd = req.getRequestDispatcher("../board/list.jsp");
			rd.forward(req,  resp);
		} 
		else if (command.contains("/BoardWriteForm.do")) {	//�� ��� ������ ����ϱ�
			requestLoginName(req);	//�޼ҵ� ����
			RequestDispatcher rd = req.getRequestDispatcher("../board/writeForm.jsp");
			rd.forward(req,  resp);
		} 
		else if (command.contains("/BoardWriteAction.do")) {	//�� �� ����ϱ�
			requestBoarderWrite(req);	//�޼ҵ� ����
			RequestDispatcher rd = req.getRequestDispatcher("../board/BoardListAction.do");
			rd.forward(req,  resp);
		} 	
		else if (command.contains("/BoardViewAction.do")) { // ���õ� �� �� ������ ��������
			requestBoardView(req);
			RequestDispatcher rd = req.getRequestDispatcher("../board/BoardView.do");
			rd.forward(req,  resp);
		}
		else if(command.contains("/BoardView.do")) { // �� �� ������ ����ϱ� 
			RequestDispatcher rd = req.getRequestDispatcher("../board/view.jsp");
			rd.forward(req,  resp);
		}
		else if(command.contains("/BoadUpdateForm.do")) { // �� ���� ������ 
			requestBoardUpdate(req);
			RequestDispatcher rd = req.getRequestDispatcher("../board/BoadUpdateForm.jsp");
			rd.forward(req, resp);
		}
		
		else if(command.contains("/BoardUpdateAction.do")) { // ���õ� ���� ��ȸ�� ����
			requestBoardUpdate(req);
			RequestDispatcher rd = req.getRequestDispatcher("../board/BoardListAction.do");
			rd.forward(req, resp);
		}
		else if(command.contains("/BoardDeleteAction.do")) { // ���õ� �� �����ϱ�
			requestBoardDelete(req);
			RequestDispatcher rd = req.getRequestDispatcher("../board/BoardListAction.do");
			rd.forward(req, resp);
		}
	}
	
	//��ϵ� �� ��� ��������
	public void requestBoardList(HttpServletRequest req) {
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		
		int pageNum = 1;	//������ ��ȣ�� ������ �� �Ǹ� 1������
		int limit = LISTCOUNT;	//������ �� �Խù� ��
		
		if(req.getParameter("pageNum")!=null) //������ ��ȣ�� ���޵� ���
			pageNum = Integer.parseInt(req.getParameter("pageNum"));
		
		String items = req.getParameter("items");	//�˻� �ʵ�
		String text = req.getParameter("text");		//�˻���
		
		int total_record = dao.getListCount(items, text);	//��ü �Խù� ��(�Ǽ��� int)
		boardlist = dao.getBoardList(pageNum, limit, items, text);	//���� �������� �ش��ϴ� ��� ������ ��� ����
		
		int total_page;		//��ü ������
		
		if(total_record % limit == 0) {	//��ü �Խù��� limit�� ����� �� ������ ��
			total_page = total_record/limit;
			Math.floor(total_page);
		}
		else {	//������ ���� �� ������ ��
			total_page = total_record/limit;	
			Math.floor(total_page);
			total_page = total_page + 1;
		}
		
		//view�� ������ �� �����ϴ� ����?
		req.setAttribute("pageNum",pageNum);			//������ ��ȣ
		req.setAttribute("total_page",total_page);		//��ü ������ ��
		req.setAttribute("total_record",total_record);	//��ü �Խù� ��
		req.setAttribute("boardlist",boardlist);		//���� �������� �ش��ϴ� ��� ������
	}
	
	//������ ����ڸ� ��������
	public void requestLoginName(HttpServletRequest request) {
		
		String id = request.getParameter("id");	//�̷��� �ϴ� �� ���� �� �� ���� session���� �޾ƾ� ��
		
		BoardDAO dao = BoardDAO.getInstance();
		
		String name =dao.getLoginNameById(id); //�̸����� �� ���ڿ� ��ȯ�ϵ��� ������
		
		request.setAttribute("name", name);		
	}
	
	
	//���� ����ϱ�
	public void requestBoarderWrite(HttpServletRequest request) {
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO board = new BoardDTO();	//request �� �ֵ��� board ��ü�� �� ����
		board.setId(request.getParameter("id"));
		board.setName(request.getParameter("name"));
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		
		//�׳� �� ������ ��� ���� ��
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("subject"));
		System.out.println(request.getParameter("content"));
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
		String regist_day = formatter.format(new java.util.Date());
		
		board.setHit(0);
		board.setRegist_day(regist_day);
		board.setIp(request.getRemoteAddr());
		
		dao.insertBoard(board);
	}
	
	// ���õ� �� �� ������ ��������
	public void requestBoardView(HttpServletRequest request) {
		BoardDAO dao = BoardDAO.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		BoardDTO board = new BoardDTO();
		board = dao.getBoardByNum(num, pageNum);
		
		request.setAttribute("num", num);
		request.setAttribute("page", pageNum);
		request.setAttribute("board", board);
	}
	
	// ���õ� �� ���� �����ϱ�
	public void requestBoardUpdate(HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO board = new BoardDTO();
		board.setNum(num);
		board.setName(request.getParameter("name"));
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		
		dao.updateBoard(board);
	}
	
	// ���õ� �� �����ϱ�
	public void requestBoardDelete(HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(num);
	}
}
