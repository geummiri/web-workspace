package model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.MemberVO;


public class MemberDAO {

public int insertMember(SqlSession session, MemberVO mOne) {
	int result = 0;
	result = session.insert("mybatis.insertMember", mOne);
	return result;
}

}