package servlet.header;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintHeaderServlet2
 */
public class PrintHeaderServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리 양방향으로 해주기
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		System.out.println("do get~~~~");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>여기는 doGet입니다.</h2>");
		
		Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			String value =request.getHeader(key);
			out.println("<p>key : " + key +", value : " + value + "</p>");
		}	
		out.close();
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
