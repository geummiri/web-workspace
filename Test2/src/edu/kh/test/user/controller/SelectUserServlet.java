package edu.kh.test.user.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;


public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		UserDTO dto = null;
	
		try {
			dto = UserDAO.getInstance().selectUser(userNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(dto!=null) {
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("views/searchSuccess.jsp");
		} else {
			response.sendRedirect("views/searchFail.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
