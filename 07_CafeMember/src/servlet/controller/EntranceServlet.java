package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;

/*
 * 회원가입하면 정보를 바탕으로
 * MemberVO를 생성. ArrayList에 추가
 * ArrayList를 통째로 ServletContext에 바인딩
 * 출력 결과는 viewMember.jsp페이지에서
 * 
 * */
public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private ServletContext context;
//	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());
//
//	public void init(ServletConfig config) throws ServletException {
//	
//		context = config.getServletContext(); 
//		doGet에서는 config가 포함되어있어서 안적어줬지만 init에서는 config가 명시되어있어서 작성해줘야함 
//		context.setAttribute("list", list); //접속하지 않아도 list불러올수있음
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setAttribute("list", list); //접속할때만 list를 불러오게끔
		String name = request.getParameter("name");
		int age = request.getParameter("age")!=null ? Integer.parseInt(request.getParameter("age")) : 0;
		String addr = request.getParameter("addr");
		System.out.println("1. 폼값을 받아온다.");
		

		MemberVO vo = new MemberVO(name, age, addr);
//		list.add(vo);
//		System.out.println("3. MemberVO를 List에 저장");

//		DAO로 데이터 전송
		MemberDAO dao = new MemberDAO();
		try {
			dao.insertMember(vo);
		} catch (SQLException e) {}
			
//		 내비게이션 -> ViewMemberServlet(PrintWriter의 다른 방법)
		//response.sendRedirect("viewMember.jsp");
//		RequestDispatcher rdp = request.getRequestDispatcher("viewMember.jsp");
//		rdp.forward(request, response); //이때 페이지로 이동함
        request.getRequestDispatcher("view").forward(request, response);
//		PrintWriter out = response.getWriter();
//		out.println("<a href='viewMember.jsp'>결과 확인하러 가기</a>");
//		out.close();
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
