package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private ServletContext context;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//update 쿼리 작성
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		
		MemberDTO dto = new MemberDTO();
		dto.setPassword(password);
		dto.setName(name);
		dto.setAddress(address);
		dto.setId(id);
		
		try {
			
			MemberDAO.getInstance().UpdateServlet(dto);
			
			context = getServletContext();
			context.setAttribute("dto", dto);
			
			response.sendRedirect("views/update_result.jsp");
			context.setAttribute("dto", dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
