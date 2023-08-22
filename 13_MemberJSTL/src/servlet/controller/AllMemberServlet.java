package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;


@WebServlet("/member/all")
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		MemberDAO dao = new MemberDAO(); 싱글톤 패턴 사용 안하면 객체 생성해서 사용해야됨
	
		try {
//			ArrayList<MemberDTO> list = dao.showAllMember();
			ArrayList<MemberDTO> list = MemberDAO.getInstance().showAllMember();
			request.setAttribute("list", list);
			//session이 너무 많은 데이터를 담아서 넘겨오는것 안좋음 왜죠??
			request.getRequestDispatcher("views/allShow.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
