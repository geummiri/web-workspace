package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberDAOTemplate {

	Connection getConnection() throws SQLException;
	
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	//멤버추가하기
	void insertMember(MemberVO vo) throws SQLException;
	
	//리스트배열로 모든 멤버 확인하기
	ArrayList<MemberVO> showAllMember() throws SQLException;
	
	//이름으로 찾기
	MemberVO findByNameMember(String name) throws SQLException;
	
}
