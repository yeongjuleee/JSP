package mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import mvc.model.BoardDAO;
import mvc.model.BoardDTO;
import mvc.model.RippleDAO;
import mvc.model.RippleDTO;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	static final int LISTCOUNT = 10;	//������ �� �Խù� ��
	private String boardName = "board";	// ������ �� �� �ִ� �Խ��� �̸�?

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
			//requestLoginName(req);	//�޼ҵ� ����
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
			requestRippleList(req, resp);
			RequestDispatcher rd = req.getRequestDispatcher("../board/BoardView.do");
			rd.forward(req,  resp);
		}
		else if(command.contains("/BoardView.do")) { // �� �� ������ ����ϱ� 
			//RequestDispatcher rd = req.getRequestDispatcher("../board/view.jsp");
			RequestDispatcher rd = req.getRequestDispatcher("../board/view_ajax.jsp");
			rd.forward(req,  resp);
		}
		else if(command.contains("/BoardUpdateForm.do")) { // �� ������  ���
			requestBoardView(req);
			RequestDispatcher rd = req.getRequestDispatcher("../board/updateForm.jsp");
			rd.forward(req, resp);
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
		else if(command.contains("/BoardRippleWriteAction.do")) { // ���� ����(jsp, ��������) contains ��ο� Board �� �߰�����!
			// �޼ҵ�
			requestBoardRippleWriteAction(req);
			
			int num = Integer.parseInt(req.getParameter("num"));
			int pageNum = Integer.parseInt(req.getParameter("pageNum"));
			resp.sendRedirect("BoardViewAction.do?num=" + num + "&pageNum=" + pageNum);
		}
		else if (command.contains("BoardRippleDeleteAction.do")) { // ���� ����(jsp, ��������)
			requestBoardRippleDelete(req);
			int num = Integer.parseInt(req.getParameter("num"));
			int pageNum = Integer.parseInt(req.getParameter("pageNum"));
			resp.sendRedirect("BoardViewAction.do?num=" + num + "&pageNum=" + pageNum);
		}
		else if (command.contains("RippleListAction.do")) { // ��� ��� ���� (ajax_ver)
			requestRippleList(req, resp);
		}
		else if (command.contains("RippleDeleteAction.do")) { // ��� ���� (ajax_ver)
			requestRippleDelete(req, resp);
		}
		else if (command.contains("RippleWriteAction.do")) {	// ��� �ۼ� (ajax_ver)
			requestRippleWrite(req, resp);
		}
		else {
			System.out.println("out : " + command);
			// ��� ȭ���� ��� ��Ʈ���� ���� ���
			PrintWriter out = resp.getWriter();
			out.append("<html><body><h2>�߸��� ��� �Դϴ�.(" + command + "</h2><hr>");
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
		req.setAttribute("limit", limit); 				//�Խù� �Ϸù�ȣ(?)
		req.setAttribute("pageNum",pageNum);			//������ ��ȣ
		req.setAttribute("total_page",total_page);		//��ü ������ ��
		req.setAttribute("total_record",total_record);	//��ü �Խù� ��
		req.setAttribute("boardlist",boardlist);		//���� �������� �ش��ϴ� ��� ������
	}
	
	//������ ����ڸ� ��������
	/*public void requestLoginName(HttpServletRequest request) {
		
		String id = request.getParameter("id");	//�̷��� �ϴ� �� ���� �� �� ���� session���� �޾ƾ� ��
		
		BoardDAO dao = BoardDAO.getInstance();
		
		String name =dao.getLoginNameById(id); //�̸����� �� ���ڿ� ��ȯ�ϵ��� ������
		
		request.setAttribute("name", name);		
	}
	*/
	
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
		
		// ����Ʈ �ִ� ���
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
	
	// ��� ���
	public void requestBoardRippleWriteAction(HttpServletRequest request) throws UnsupportedEncodingException {
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		RippleDAO dao = RippleDAO.getInstance();
		RippleDTO ripple = new RippleDTO();
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		ripple.setBoardName(this.boardName);
		ripple.setBoardNum(num);
		ripple.setMemberId((String) session.getAttribute("sessionId"));
		ripple.setName(request.getParameter("name"));
		ripple.setContent(request.getParameter("content"));
		ripple.setIp(request.getRemoteAddr());
		
		dao.insertRipple(ripple);
		
		// ����Ʈ �ִ� ��� 
	}
	
	
	// ��� ��� ��������
	public void requestRippleList(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		String sessionId = (String) session.getAttribute("sessionId");
		
		String boardName = req.getParameter("boardName");
		int num = Integer.parseInt(req.getParameter("num"));
		
		RippleDAO dao = RippleDAO.getInstance();
		ArrayList<RippleDTO> list = dao.getRippleList(boardName, num);
		
		StringBuilder result = new StringBuilder("{ \"listData\" : [");
		int i = 0;
		for (RippleDTO dto : list) {
			boolean flag = sessionId != null && sessionId.equals(dto.getMemberId()) ? true : false;
			result.append("{\"rippleId\" : \"").append(dto.getRippleId()).append("\", \"name\" : \"").append(dto.getName())
			.append("\", \"content\" : \"").append(dto.getContent()).append("\", \"isWriter\": \"").append(flag).append("\" }");
			// value�� �迭 ���·� ���� ������ ����� ��� �޸��� ������ X
			
			if (i++ < list.size() - 1)
				result.append(", ");
		}
		result.append("]}");
		
		// ��� ȭ���� ��� ��Ʈ���� ���� ���
		PrintWriter out = resp.getWriter();
		out.append(result.toString());
		
	}	
		
	// ��� �����ϱ� 
	public void requestBoardRippleDelete(HttpServletRequest request) throws UnsupportedEncodingException {
		int rippleId = Integer.parseInt(request.getParameter("rippleId"));
		
		RippleDAO dao = RippleDAO.getInstance();
		RippleDTO ripple = new RippleDTO();
		ripple.setRippleId(rippleId);
		dao.deleteRipple(ripple);
		
	} //��� �����ϱ� 
	
	// ���� ����(ajax_ver)
	public void requestRippleDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int rippleId = Integer.parseInt(req.getParameter("rippleId"));
		RippleDAO dao = RippleDAO.getInstance();
		RippleDTO ripple = new RippleDTO();
		ripple.setRippleId(rippleId);
		
		String result = "{ \"result\" : ";
		if (dao.deleteRipple(ripple)) {
			result += "\"true\"}";
		}
		else {
			result += "\"false\"}";
		}
		// ��� ȭ���� ��� ��Ʈ���� ���� ���
		PrintWriter out = resp.getWriter();
		out.append(result);
	} // requestRippleDelete ��
	
	public void requestRippleWrite(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		RippleDAO dao = RippleDAO.getInstance();
		RippleDTO ripple = new RippleDTO();
		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		
		ripple.setBoardName(req.getParameter("boardName"));
		ripple.setBoardNum(Integer.parseInt(req.getParameter("num")));
		ripple.setMemberId((String)session.getAttribute("sessionId"));
		ripple.setName(req.getParameter("name"));
		ripple.setContent(req.getParameter("content"));
		ripple.setIp(req.getRemoteAddr());
		
		String result = "{ \"result\" : ";
		if (dao.insertRipple(ripple)) {
			result += "\"true\"}";
		}
		else {
			result += "\"false\"}";
		}
		// ��� ȭ���� ��� ��Ʈ���� ���� ���
		PrintWriter out = resp.getWriter();
		out.append(result);
	} // requestRippleWrite ��
}
