package member.controller.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class FindController implements Controller {
	
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "views/find_fail.jsp";
		
		String id = request.getParameter("id");
		String addr = request.getParameter("addr");
		
		String[] idList = request.getParameterValues("checkId");
		//배열 가져오려면 getParameterValues로 form 값 가져오기
		MemberVO vo = new MemberVO();
		if(id!="") vo.setId(id);
		if(addr!="") vo.setAddress(addr);
		
		List<MemberVO> list = new MemberService().findByIdMember(idList);
		
		if(list != null) {
			request.setAttribute("list", list);
			path = "views/allShow.jsp";
		}
		// 데이터 바인딩한게(request) 있어서 forward로 보내야햠!
		// 데이터 바인딩 없으면 path, true 작성하면 됨 sendRedirect로 보내면 됨
		return new ModelAndView(path);
	}
}