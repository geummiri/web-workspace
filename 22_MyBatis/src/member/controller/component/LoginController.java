package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class LoginController implements Controller{

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberVO m = new MemberVO();
		m.setId(id);
		m.setPassword(password);
		
		MemberVO vo = new MemberService().login(m);
		
		HttpSession session = request.getSession();
		
		if(vo!=null) {
			session.setAttribute("vo", vo); //세션에 vo가 있으면 로그인한 상태이다
		}
		
		return new ModelAndView("views/login_result.jsp", true);
	}
	
}
