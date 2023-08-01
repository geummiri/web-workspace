package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpFormServlet
 */
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 한글처리..양방향!
		 * request, response 
		 * */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String[] menuList = request.getParameterValues("menu");
		String gender = request.getParameter("gender");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>정보를 출력합니다.</h2>");
		out.println("<p>당신의 아이디는 " + userId + "입니다.</p>");
		out.println("<p>당신의 비밀번호는 " + userPwd + "입니다.</p>");
//		당신의 성별은 --> form.html 라디오 사용!
//		out.println("<p>Selected Menu List: " + Arrays.toString(menuList) + "</p>");
		
		out.println("<p>좋아하는 음식은</p>");
		out.println("<ol>");
		for(String menu : menuList) {
			out.println("<li>" + menu + "</li>");
		}
		out.println("</ol>");
		//스트링 타입이여서 charAt으로 확인해준 후에 코드 집어넣깅
		out.println("<p> 성별은 " + (gender.charAt(0) == 'M' ? "남자" : "여자") + "입니다.</p>");
		
		out.close();
	}

}
