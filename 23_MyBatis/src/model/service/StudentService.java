package model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.Template;
import model.dao.StudentDAO;
import model.vo.StudentVO;

public class StudentService {
	
	public List<StudentVO> showStudent(String word) throws SQLException {
		SqlSession sqlSession = Template.getSqlSession();
		List<StudentVO> student = StudentDAO.getInstance().showStudent(sqlSession, word);
		sqlSession.close();
		return student;
	}
}
