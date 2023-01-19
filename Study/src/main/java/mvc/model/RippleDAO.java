package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mvc.database.DBConnection;

public class RippleDAO {
	private static RippleDAO instance;
	
	public static RippleDAO getInstance() {
		if(instance == null)
			instance = new RippleDAO();
		return instance;
	}
	
	// ��� �߰�
	public void insertRipple (RippleDTO ripple) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			
			String sql = "INSERT INTO ripple VALUES(?,?,?,?,?,?,now(),?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ripple.getRippleId());
			pstmt.setString(2, ripple.getBoardName());
			pstmt.setInt(3, ripple.getBoardNum());
			pstmt.setString(4, ripple.getMemberId());
			pstmt.setString(5, ripple.getName());
			pstmt.setString(6, ripple.getContent());
			pstmt.setString(7, ripple.getIp());
			
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("insertRipple() ����: "+ex);			
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
		
	} // insertRipple ��	
	
	// ripple ���̺��� ���(���ڵ�) ��������
	public ArrayList<RippleDTO> getRippleList(String boardName, int boardNum) {
		// �Խ��� ������ �Խñ� ��ȣ�� �����ͼ� ��� ��������
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM ripple WHERE boardName = ? AND boardNum = ?";
		ArrayList<RippleDTO> list = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardName);
			pstmt.setInt(2, boardNum);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				RippleDTO ripple = new RippleDTO();
				ripple.setRippleId(rs.getInt("rippleId"));
				ripple.setBoardName(rs.getString("boardName"));
				ripple.setBoardNum(rs.getInt("boardNum"));
				ripple.setMemberId(rs.getString("memberId"));
				ripple.setName(rs.getString("name"));
				ripple.setContent(rs.getString("content"));
				ripple.setInsertDate(rs.getString("insertDate"));
				ripple.setIp(rs.getString("ip"));
				list.add(ripple);
			}			
		} catch (Exception ex) {
			System.out.println("getRippleList() ���� : "+ ex);
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
		return list;
	} // getRippleList(���� ��� ��������) ��
	
	// ��� �����ϱ�
	public void deleteRipple(RippleDTO ripple) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			
			String sql = "DELETE FROM ripple WHERE rippleId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ripple.getRippleId());
			// rippleId�� ripple�� �޾ƿͼ� ���� ������.
			pstmt.executeUpdate();
		
		} catch (Exception ex) {
			System.out.println("deleteRipple() ���� : " + ex);
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
		
	} // deleteRipple ��� ���� ��
	
} // RippleDTO ��
