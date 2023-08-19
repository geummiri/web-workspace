package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.model.vo.MemberDTO;

	public class MemberRepository implements MemberDAOTemplate{
			//싱글톤 빼고 작성하기
		
		@Override
		public Connection getConnection() throws SQLException {
			Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
			System.out.println("DB Connection!");
			return conn;
		}
		//메서드명이 같은게 여러개 올수있는게 오버로딩
		@Override
		public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
			ps.close();
			conn.close();
		}

		@Override
		public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
			rs.close();
			closeAll(ps,conn);
		}

		@Override
		public void registerMember(MemberDTO dto) throws SQLException {
			Connection conn = getConnection();
			
			String query = " INTO MEMBER(ID, PASSWORD, NAME, ADDRESS) VALUES(?, ?, ?, ?)";
			//객체생성하는 statement 사용하기 위해 쿼리문 작성해주기
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getAddress());
			
			System.out.println(ps.executeUpdate() + "명 가입 완료");
			
			closeAll(ps,conn);
		}

		@Override
		public MemberDTO login(String id, String password) throws SQLException {
			Connection conn = getConnection();
			
			String query = "SELECT * FROM MEMBER WHERE id=? and password=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			MemberDTO dto = null;
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
			}
			
			closeAll(rs, ps, conn);
			
			return dto;
		}

		@Override
		public MemberDTO findByIdMember(String id) throws SQLException {
			Connection conn = getConnection();
			
			String query = "SELECT * FROM MEMBER WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			MemberDTO dto = null;
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
			}
			
			closeAll(rs, ps, conn);
			
			return dto;
		}

		@Override
		public ArrayList<MemberDTO> showAllMember() throws SQLException {
			Connection conn = getConnection();
			
			String query = "SELECT * FROM MEMBER";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<MemberDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				list.add(dto);
			}
			
			closeAll(rs, ps, conn);
			
			return list;
		}
		@Override
		public void UpdateServlet(MemberDTO dto) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		
		
		
	}
		
		

		

