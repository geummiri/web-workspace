package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private ServletContext context;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//1. 폼값을 가져온다.
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	
	//2. 객체 생성 후 폼값 담기
	MemberDTO dto1 = new MemberDTO();
	dto1.setId(id);
	dto1.setPassword(password);
	dto1.setName(name);
	dto1.setAddress(address);
	
	try {
	//3. DAO와 연결해주기
//		MemberDAO dao = new MemberDAO();
		MemberDAO.getInstance().registerMember(dto);
		
		//4. 데이터 바인딩 -> 회원가입 후 바로 로그인 되게끔
		HttpSession session = request.getSession();
		session.setAttribute("dto", dto);
		
		//5.네비게이션
		response.sendRedirect("AllMemberServlet");
		
	} catch (SQLException e) {
		System.out.println("회원가입 실패!!");
		response.sendRedirect("../index.jsp");
	}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
