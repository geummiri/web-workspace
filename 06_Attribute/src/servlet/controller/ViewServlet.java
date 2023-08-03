package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletContext context; //객체 바인딩
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String name = request.getParameter("name");
//		int age = Integer.parseInt(request.getParameter("age"));
//		String addr = request.getParameter("addr"); 
//		이거 이제 안써도됨 객체 바인딩 했으니까 객체 가져와서 변수 집어넣기
		
		/*
		 * 1. Attribute에 바인딩된 데이터를 받아와서
		 * 2. 웹브라우저로 출력하는 로직을 작성
		 * */
		
		//1. Attribute에 바인딩된 데이터를 받아와서
		context = getServletContext();
		MemberVO vo = (MemberVO) context.getAttribute("vo"); //cast -> 데이터 타입을 다른 데이터 타입으로 변환
		
		
		//2. 웹브라우저로 출력하는 로직을 작성
		PrintWriter out = response.getWriter();
		out.println("<h2>회원님의 정보를 출력합니다</h2>");
		out.println("<p>이름 : " + vo.getName() + "</p>");
		out.println("<p>나이 : " + vo.getAge() + "</p>");
		out.println("<p>주소 : " + vo.getAddr() + "</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//값을 내보내는것이여서 doPost에 작성하는게 맞으나 아래 메서드가 doGet을 호출하기 때문에 doGet에 작성해주기!
		doGet(request, response);
	}

}
