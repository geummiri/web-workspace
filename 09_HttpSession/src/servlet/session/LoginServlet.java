package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 세션을 받아온다. request.getSession()
		HttpSession session = request.getSession();
		//클라이언트가 서버에 요청하는 순간 세션은 자동으로 만들어짐
		//쿠키보다 세션이 보안 높음
		
		//2. 폼에 입력된 값을 가지고 객체 생성 MemberVO (DAO 생략)
		String id = request.getParameter("id");
		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, password, "미리", "서울");
		
		
		//3. 세션에 바인딩
		session.setAttribute("vo", vo);
		
		//4. 네비게이션
		PrintWriter out = response.getWriter();
		out.println("<a href=ProductServlet>ProductServlet...</a>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
