package mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mvc.dto.AddressBookDTO;

public class AddressBookDAO {
	Connection connection = null;
	PreparedStatement pstmt = null;
	
	String jdbc_driver = "org.mariadb.jdbc.Driver";
	String jdbc_url = "jdbc:mariadb://localhost:3308/servlet";
	
	// DB 연결 메소드
	void connect() {
		try {
			Class.forName(jdbc_driver);
			
			connection = DriverManager.getConnection(jdbc_url, "root", "0732");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 파라미터에 따른 요청 처리
	// 주소록 목록 요청인 경우
	public ArrayList<AddressBookDTO> getDBList() { 
		// 전체 주소록 목록을 가져오는 메소드
		
		connect();
		ArrayList<AddressBookDTO> datas = new ArrayList<AddressBookDTO>();
		
		String sql = "SELECT * FROM address_book ORDER BY id DESC";
		try {
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				AddressBookDTO addressBookDTO = new AddressBookDTO();
				
				addressBookDTO.setId(rs.getInt("id"));
				addressBookDTO.setName(rs.getString("name"));
				addressBookDTO.setEmail(rs.getString("email"));
				addressBookDTO.setComdept(rs.getString("comdept"));
				addressBookDTO.setBirth(rs.getString("birth"));
				addressBookDTO.setTel(rs.getString("tel"));
				addressBookDTO.setMemo(rs.getString("memo"));
				datas.add(addressBookDTO);
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return datas;
	}
	
	// 신규 주소록 메시지 추가 메소드
	public boolean insertDB(AddressBookDTO dto) {
		connect();
		
		// sql 문자열, id는 자동 등록 => 입력 X
		String sql = "INSERT INTO address_book (name, email, birth, tel, comdept, memo) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getBirth());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getComdept());
			pstmt.setString(6, dto.getMemo());
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			disconnect();
		}
		return true;
	}
	
	// 특정 주소로 게시글 가져오는 메소드
	public AddressBookDTO getDB(int id) {
		connect();
		
		String sql = "SELECT * FROM address_book WHERE id =?";
		AddressBookDTO dto = new AddressBookDTO();
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			// 데이터가 하나만 있으므로 rs.next()를 한번만 실행함
			rs.next();
			dto.setId(rs.getInt("id"));
			dto.setName(rs.getString("name"));
			dto.setEmail(rs.getString("email"));
			dto.setBirth(rs.getString("birth"));
			dto.setTel(rs.getString("tel"));
			dto.setComdept(rs.getString("comdept"));
			dto.setMemo(rs.getString("memo"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return dto;
	}
	
	// 주소록 수정 업데이트 
	public boolean updateDB(AddressBookDTO dto) {
		connect();
		
		String sql = "UPDATE address_book SET name = ?, email = ?, tel = ?, birth = ?, comdept = ?, memo =? WHERE id = ?";
		
		try {
			pstmt = connection.prepareStatement(sql);
		
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getBirth());
			pstmt.setString(5, dto.getComdept());
			pstmt.setString(6, dto.getMemo());
			pstmt.setInt(7, dto.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			disconnect();
		}
		return true;
	}
	
	// 주소 삭제 
	public boolean deleteDB(int id) {
		connect();
		
		String sql = "DELETE FROM address_book WHERE id = ?";
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			disconnect();
		}
		return true;
	}
	
	// 주소 목록 검색
	public ArrayList<AddressBookDTO> getDBListBySearch(String part, String keyword) {
        connect();
        ArrayList<AddressBookDTO> datas = new ArrayList<>();

        String sql = "SELECT * FROM address_book WHERE " + part + " LIKE ? ORDER BY id DESC";
        System.out.println(sql);

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                AddressBookDTO addressBookDTO = new AddressBookDTO();

                addressBookDTO.setId(rs.getInt("id"));
                addressBookDTO.setName(rs.getString("name"));
                addressBookDTO.setEmail(rs.getString("email"));
                addressBookDTO.setComdept(rs.getString("comdept"));
                addressBookDTO.setBirth(rs.getString("birth"));
                addressBookDTO.setTel(rs.getString("tel"));
                addressBookDTO.setMemo(rs.getString("memo"));
                datas.add(addressBookDTO);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return datas;
    }

}
