package servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WordServlet
 */
public class WordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//정적인 웹서비스는 새로고침 안해줘도 됨   서블릿을 변경할때는 restart하기
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 *1.폼값 받아서
		 *2.다시 웹브라우저로 전송.. 출력
		 * 
		 */
		String result = request.getParameter("word");
		// word는 index.html에서 word값의 name값
		 		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Client Send Data ..</h2>");
		out.println("<p>" + result + "</p>");
		out.println("</body></html>");
		
		out.close();

	}

}
