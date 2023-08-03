package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context; //객체 바인딩 해주기
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.양방향 한글처리 (필터에서 처리해주므로 작성 안해도됨)
		//request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
		
		//2.폼값 받아오기
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		
		//3.vo 객체 생성
		MemberVO vo = new MemberVO(name, age, addr);
		
		//4.객체 바인딩
		context = getServletContext();
		context.setAttribute("vo", vo);
		
		PrintWriter out = response.getWriter();
		//또 다른 서블릿 파일에서 값 추출되게 하기!
		// a링크로 ViewServlet 결과 확인하러 가기
		
		//3. ViewServlet (view)한테 결과(이름, 나이, 주소) 출력
		//out.println("<a href='view?name=" +name+ "&age=" +age+ "&addr=" + addr +"'>ViewServlet 결과 확인하러 고고씽</a>");
		//out.println("<a href=view?name=" +name+ "&age=" + age + "&addr=" + addr +">ViewServlet 결과 확인하러 가기</a>");
		
		

		//out.println("<a href='view'>ViewServlet 결과 확인하러 가기");
		out.println("<a href='result.jsp'>결과 확인하러 가기</a>");
		
		out.close();
	
		
		//로직은 여기서 작성!
		/*
		 * 1. 양방향 한글처리 (filter 처리함)
		 * 2. 폼값 받아서
		 * 3. vo 객체 생성
		 * 4. 객체 바인딩.. ServletContext -> private ServletContext context;
		 * 5. ViewServlet (view)한테 결과(이름, 나이, 주소) 출력
		 * */	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
