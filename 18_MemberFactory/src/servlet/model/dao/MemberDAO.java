package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

import servlet.model.vo.MemberVO;



public class MemberDAO implements MemberDAOTemplate{

	//싱글톤 패턴 - 클래스의 객체가 항상 하나만 존재하도록
	
	/*
	 * DAO를 반복적으로 생성하고 해제하는 것은 비효율적
	 * 객체지향적으로 설계를 하자~해서 
	 * 싱글톤패턴은 객체지향적 설계 원칙을 준수함
	 * 주의할 점!
	 * - 싱글톤은 전역 상태를 가질 수 있으므로 오남용하면 애플리케이션의 복잡성이 증가함
	 * */
	
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance() {
		return dao;
		
	}
//	아래 방법 사용 원치 않으면 싱글톤패턴 방법으로 코드 작성
//	public MemberDAO() {
//		
//		//jdbc 연결하기 위해서 드라이버 로딩
//		try {
//			Class.forName(ServerInfo.DRIVER_NAME);
//			System.out.println("Driver Loading Success!!!!");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
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
	public void registerMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		
		String query = "INSERT INTO MEMBER(ID, PASSWORD, NAME, ADDRESS) VALUES(?, ?, ?, ?)";
		//객체생성하는 statement 사용하기 위해 쿼리문 작성해주기
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getAddress());
		
		System.out.println(ps.executeUpdate() + "명 가입 완료");
		
		closeAll(ps,conn);
	}

	@Override
	public MemberVO login(String id, String password) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER WHERE id=? and password=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		MemberVO vo = null;
		if(rs.next()) {
			vo = new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
			vo.setName(rs.getString("name"));
			vo.setAddress(rs.getString("address"));
		}
		
		closeAll(rs, ps, conn);
		
		return vo;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		MemberVO vo = null;
		if(rs.next()) {
			vo= new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
			vo.setName(rs.getString("name"));
			vo.setAddress(rs.getString("address"));
		}
		
		closeAll(rs, ps, conn);
		
		return vo;
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MemberVO> list = new ArrayList<>();
		
		while(rs.next()) {
			MemberVO vo = new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
			vo.setName(rs.getString("name"));
			vo.setAddress(rs.getString("address"));
			list.add(vo);
		}
		
		closeAll(rs, ps, conn);
		
		return list;
	}
	
	
	@Override
	public void UpdateServlet(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		
		String query = "UPDATE MEMBER SET PASSWORD=?, NAME=?, ADDRESS=? WHERE ID=?";
		//객체생성하는 statement 사용하기 위해 쿼리문 작성해주기
		PreparedStatement ps = conn.prepareStatement(query);
		
		
		ps.setString(1, vo.getPassword());
		ps.setString(2,vo.getName());
		ps.setString(3, vo.getAddress());
		ps.setString(4, vo.getId());
		
		
		System.out.println(ps.executeUpdate() + "명 수정 완료");
		
		closeAll(ps,conn);
	}
	
	
	
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setId("user1");
		vo.setPassword("user1");
		vo.setName("user1");
		vo.setAddress("user1");
		
		
		try {
			vo = dao.login("user1","user1");
			System.out.println("name " + vo.getName());
			System.out.println("address " + vo.getAddress());
//			dao.registerMember(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	
	

	

