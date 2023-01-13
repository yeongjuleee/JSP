package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import mvc.database.DBConnection;

public class BoardDAO {
	//DAO(Data Access Object)�� ������ ���̽��� data�� �����ϱ� ���� ��ü
	//�̱��� Ÿ������ �ۼ�
	private static BoardDAO instance;
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		if(instance == null)
			instance = new BoardDAO();
		return instance;
	}
	
	//board ���̺��� ���ڵ� ���� 
	public int getListCount(String items, String text) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;	//��ü �Խù��� �� (���ڵ� ����) �����ϴ� ����
		
		String sql;
		
		if (items == null && text == null) 
			sql = "SELECT count(*) FROM board";
		else
			sql="SELECT count(*) FROM board WHERE " + items + "LIKE '%" + text + "%'";
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = rs.getInt(1);
		} catch (Exception ex) {
			System.out.println("getListCount() ����: "+ex);			
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		} return x;		
	}
	
	//board ���̺��� ���ڵ� ��������
	public ArrayList<BoardDTO> getBoardList(int page, int limit, String items, String text) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//��ü �Խù� �� ���ϱ�
		int total_record = getListCount(items, text);
		int start = (page -1) * limit;
		int index = start + 1;
		
		String sql;
		
		if (items == null && text == null)
			sql = "SELECT * FROM board ORDER BY num DESC";
		else
			sql = "SELECT * FROM board WHERE " + items + "LIKE '%" + text + "%' ORDER BY num DESC";
			//limit ���� ������� ����
			//
		
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//ResultSet.ababsolute(int index) : ResultSet Ŀ���� ���ϴ� ��ġ(Index)�� �˻������� �̵��ϴ� �޼ҵ�
			while (rs.absolute(index)) {
				BoardDTO board = new BoardDTO();
				board.setNum(rs.getInt("num"));
				board.setId(rs.getString("id"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setRegist_day(rs.getString("regist_day"));
				board.setHit(rs.getInt("hit"));
				board.setIp(rs.getString("ip"));
				list.add(board);
				
				if (index < (start + limit) && index <= total_record)
					index++;
				else
					break;
			}
			return list;			
		} catch (Exception ex) {
			System.out.println("getBoardList() ���� : "+ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
		return null;

	}
	
	//��� ���̺��� ������ ȸ�� ���� ��������
	public String getLoginNameById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String name = null;		
		String sql = "SELECT * FROM member WHERE id=?";
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();	
			
			if(rs.next())
				name = rs.getString("name");
		} catch (Exception ex) {
			System.out.println("getListCount() ����: "+ex);			
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		} return name;	
		
	}
	
	public void insertBoard (BoardDTO board) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			
			String sql = "INSERT INTO board VALUES(?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getNum());
			pstmt.setString(2, board.getId());
			pstmt.setString(3, board.getName());
			pstmt.setString(4, board.getSubject());
			pstmt.setString(5, board.getContent());
			pstmt.setString(6, board.getRegist_day());
			pstmt.setInt(7, board.getHit());
			pstmt.setString(8, board.getIp());
			
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("getListCount() ����: "+ex);			
		} finally {
			try {
				
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		} 
	}
	
	// ���õ� �� �� ���� ��������
	public BoardDTO getBoardByNum(int num, int page) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO board = null;
		
		updateHit(num);
		String sql = "SELECT * FROM board WHERE num = ?";
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				board = new BoardDTO();
				board.setNum(rs.getInt("num"));
				board.setId(rs.getString("id"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setRegist_day(rs.getString("regist_day"));
				board.setHit(rs.getInt("hit"));
				board.setIp(rs.getString("ip"));
			}
			
		} catch (Exception ex) {
			System.out.println("getBoardByNum() ����: "+ex);	
			
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		} return board;	
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

	// ��ȸ�� ������Ʈ
	public void updateHit(int num) {
		// ���õ� ���� ��ȸ�� �����ϱ�. view ���������� ���
		// getBoardByNum() ���� ȣ��. �ܺο��� ȣ���� �ȵǾ private ���!
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
		/* ������
			String sql = "SELECT hit FROM board WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			int hit = 0;
			
			if (rs.next()) 
				hit = rs.getInt("hit") + 1;
			
			sql = "UPDATE board SET hit = ? WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hit);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
		 */
			
			//������ ���̴� ���
	         String sql = "UPDATE board SET hit = hit + 1 WHERE num =?";
	         
	         conn = DBConnection.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1,  num);
	         pstmt.executeUpdate();
			
		} catch (Exception ex) {
			System.out.println("updateHit() ���� : " +  ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
		
	}
	
	public void updateBoard(BoardDTO board) {
		// ���õ� �� ���� �����ϱ� �޼ҵ�
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			
			String sql = "UPDATE board SET name = ?, subject = ?, content = ? WHERE num =?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, board.getName());
	        pstmt.setString(2,  board.getSubject());
	        pstmt.setString(3,  board.getContent());
	        pstmt.setInt(4, board.getNum());
	        
	        pstmt.executeUpdate();
		        
		} catch (Exception ex) {
			System.out.println("updateBoard() ���� : " +  ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
	}

	public void deleteBoard(int num) {
		// ���õ� �� �����ϱ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			
			String sql = "DELETE FROM board WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch(Exception ex) {
			System.out.println("deleteBoard() ���� : " +  ex);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
	}
}