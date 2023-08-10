package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class RegisterController implements Controller {

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		String path = "index.jsp";
		
		MemberVO vo = new MemberVO(id, password, name, address);
		MemberDAO.getInstance().registerMember(vo);
		
		HttpSession session = request.getSession();
		
		if(session!=null) {
			session.setAttribute("vo", vo);
			path = "/index.jsp";
		}
		
		return new ModelAndView(path);
	}

}
