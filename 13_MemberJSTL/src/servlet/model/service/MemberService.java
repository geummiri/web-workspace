package servlet.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import servlet.model.dao.MemberRepository;
import servlet.model.vo.MemberDTO;

public class MemberService  {
	//MemberVO랑 이름만 다른거지 기능은 같음
	private MemberRepository repo = new MemberRepository();
	
	public ArrayList<MemberDTO> showAllMember() throws SQLException {
		return repo.showAllMember();
	}
}
