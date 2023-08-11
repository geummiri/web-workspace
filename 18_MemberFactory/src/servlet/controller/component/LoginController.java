package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class LoginController implements Controller{

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberVO vo = MemberDAO.getInstance().login(id, password);
		
		/*
		데이터 바인딩 - request, session, context
		setAttribute
		request <--범위가 가장 좁음 / 요청이 들어오면 응답을 하며 바로 쓰이는 데이터 값
		
		session <-- 로그인/로그아웃  // invalidate 된 상태까지 session의 범위이다
		회원가입 후 로그인된상태 or 회원가입 후 로그인 다시 해야하는 상태 두개가 있을 떄
		
		context <--범위가 가장 넓음 / 서블릿보다 먼저 띄워짐 서버가 띄워질 때 부터 서버 내려질 때까지 계속 띄워져있음
					(거의 사용 안할거임 / 이런것도 있다는걸 알려주기 위해서 사용해본것)
		
		*/
		HttpSession session = request.getSession();
		
		if(vo!=null) {
			session.setAttribute("vo", vo); //세션에 vo가 있으면 로그인한 상태이다
		}
		
		return new ModelAndView("views/login_result.jsp");
	}
	
}
