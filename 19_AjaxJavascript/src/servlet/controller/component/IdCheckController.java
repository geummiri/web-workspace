package servlet.controller.component;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class IdCheckController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		
		boolean flag = false;
		
		//아이디가 있는지 확인 후 true값으로 반환하기
		if(vo!=null) {
			flag = true;
		}
		
		
		//비동기방식
		PrintWriter out = response.getWriter();
		out.print(flag);
		
		
		return null;
		
		
//		if(vo!=null) {
//		out.println("ID 사용 불가");
//	} else {
//		out.println("ID 사용 가능");
//	}
//	
//	return new ModelAndView();
		
		
	}

}
