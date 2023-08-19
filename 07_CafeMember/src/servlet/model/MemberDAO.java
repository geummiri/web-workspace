package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import servlet.config.ServerInfo;

public class MemberDAO implements MemberDAOTemplate{
	
	private Properties p = new Properties();

	public static void main(String[] args) {
		
		MemberDAO dao = new MemberDAO();
		
		
		try {
			dao.showAllMember();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		try {
//			dao.insertMember(new MemberVO("마마마", 3, "바바바"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
	//생성자 생성
	public MemberDAO() {
		
	//1. 드라이버 로딩
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//2. 데이터베이스와 연결
	@Override
	public Connection getConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ex","sample","SAMPLE");
		System.out.println("DB Connection...!");
		
		return conn;
	}
	
	//5. close 닫기
	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	
	// resultSet까지 3개 닫기
	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}
	
	
	@Override
	public void insertMember(MemberVO vo) throws SQLException {
		
		Connection conn = getConnection();
		
		String query = "INSERT INTO MEMBER(NAME, AGE,ADDR) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
				
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getAge());
			ps.setString(3, vo.getAddr());
			
			System.out.println(ps.executeUpdate() + "명 가입!!");
			
		closeAll(ps, conn);
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
//		
//		PreparedStatement ps = conn.prepareStatement(p.getProperty("showAllMember"));
//		ResultSet rs = ps.executeQuery();
//		
//		ArrayList<MemberVO> memberList = new ArrayList<>();
//		while(rs.next()) {
//			MemberVO vo = new MemberVO();
//			vo.setName(rs.getString("name"));
//			vo.setAge(rs.getInt("age"));
//			vo.setAddr(rs.getString("addr"));
//			memberList.add(vo);
//		}
//		closeAll(rs,ps,conn);
//		
//		return memberList;
		// 3. Statement 객체 생성
		String query = "SELECT * FROM MEMBER";
		PreparedStatement ps = conn.prepareStatement(query);
		
		// 4. 쿼리문 실행
		ArrayList<MemberVO> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new MemberVO(rs.getString("name"), 
					rs.getInt("age"), rs.getString("addr")));
		}
		
		closeAll(rs, ps, conn);
		return list;
		
		
	}

	@Override
	public MemberVO findByNameMember(String name) throws SQLException {
		
		Connection conn = getConnection();
//		String query = "SELECT NAME FROM MEMBER WHERE NAME = ?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		
//		ResultSet rs = ps.executeQuery();
//		return (MemberVO) rs;
		// 3. Statement 객체 생성
		String query = "SELECT * FROM MEMBER WHERE NAME=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		
		// 4. 쿼리문 실행
		MemberVO vo = null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			vo = new MemberVO(rs.getString("name"), 
					rs.getInt("age"), rs.getString("addr"));
		}
		
		closeAll(rs, ps, conn);
		return vo;
		
	}
	
	
}
