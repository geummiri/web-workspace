package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class RegisterController implements Controller {

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.폼값 4개 받아오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		//2.폼값 4개 vo에 넣어주기
		MemberVO vo = new MemberVO(id, password, name, address);
		new MemberService().registerMember(vo);
		//데이터 바인딩 안해도 됨
		//회원가입만 하고 로그인은 따로 하겠다 라는 뜻! 
		//session 작성해주면 바로 로그인 되어있는 상태로 넘어감
		String path = "index.jsp";
		
//		HttpSession session = request.getSession();
//		
//		if(session!=null) {
//			session.setAttribute("vo", vo);
//			path = "/index.jsp";
//		}
		
		return new ModelAndView(path);
	}

}
