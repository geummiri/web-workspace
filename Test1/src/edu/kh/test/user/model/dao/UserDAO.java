package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.kh.test.user.config.ServerInfo1;
import edu.kh.test.user.model.vo.UserDTO;


public class UserDAO {
	
	private static UserDAO dao = new UserDAO();

	private UserDAO(){
		try {
			Class.forName(ServerInfo1.DRIVER_NAME);
			System.out.println("Driver Loading");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static UserDAO getInstance() throws SQLException {
		return dao;
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo1.URL, ServerInfo1.USER, ServerInfo1.PASSWORD);
		System.out.println("DB Connection!!");
		return conn;
	}
	
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{
		rs.close();
		ps.close();
		conn.close();
	}
	
	
	public UserDTO selectUser(int userNo) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM TB_USER WHERE USER_NO=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, userNo);
		
		ResultSet rs = ps.executeQuery();
		
		UserDTO dto = null;
		
		if(rs.next()) {
			dto = new UserDTO();
			dto.setUserNo(rs.getInt("userNo"));
			dto.setUserId(rs.getString("userId"));
			dto.setUserName(rs.getString("userName"));
			dto.setUserAge(rs.getInt("userAge"));
		}
		closeAll(rs, ps, conn);
		return dto;
	}
}
