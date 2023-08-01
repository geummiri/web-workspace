package servlet.header;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintHeaderServlet
 */
public class PrintHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("service~~~~");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//한글처리
		
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		out.println("<h2>여기는 서비스입니다~~</h2>");
		out.println("<p>ID : " + id + "</p>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.err.println("do get~~~~");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>여기는 doGet입니다.</h2>");
		
		
		//header정보 가져오기
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//key들로만 가지고 있음/모든 헤더(header) 이름들을 가져오는 메서드/ getHeaderNames()
		//Enumeration : 컬렉션에 저장된 요소들을 반복하여 가져올 수 있는 방법을 제공
		// 모든 헤더의 이름들을 순회하고 확인할 수 있음
		Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			String value =request.getHeader(key);
			out.println("<p>key : " + key +", value : " + value + "</p>");
			out.close();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
	

}
