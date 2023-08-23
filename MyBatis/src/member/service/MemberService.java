package member.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.MemberVO;

import common.SqlSessionTemplate;
import model.dao.MemberDAO;

//public class MemberService {
//	public int insertMember(MemberVO vo) throws SQLException {
//		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
//		int result = new MemberDAO().insertMember(sqlSession, vo);
//		if(result>0) sqlSession.commit();
//		sqlSession.close();
//		return result;
//	}
//}

public class MemberServiceImpl{

public int insertMember(MemberVO mOne)throws SQLException  {
	SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
	int result = new MemberDAO().insertMember(sqlSession, mOne);
	if(result>0) sqlSession.commit();
	sqlSession.close();
	return result;
}
}
//}new MemberDAO().insertMember(sqlSession, mOne);