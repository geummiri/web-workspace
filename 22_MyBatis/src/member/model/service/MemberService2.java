package member.model.service;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.MemberVO;

public class MemberService2 {

	public int registerMember(MemberVO vo) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = MemberDAO.getInstance().registerMember(sqlSession, vo);
		
		if(result>0) sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
	
	public List<MemberVO> showAllMember() {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		List<MemberVO> member = MemberDAO.getInstance().showAllMember(sqlSession);
		
		sqlSession.close();
		
		//값 변경
		return member;
	}
	
	public List<MemberVO> findByIdMember(String[] idList) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		List<String> list = Arrays.asList(idList);
		List<MemberVO> member = MemberDAO.getInstance().findByIdMember(sqlSession, list);
		sqlSession.close();
		return member;
	}
	
	
	public MemberVO login(MemberVO vo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		MemberVO member = MemberDAO.getInstance().login(session, vo);
		session.close();
		
		return member;
	}
}
