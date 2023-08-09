package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

@WebServlet(urlPatterns="/front.do")
public class DispatcherServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//command 랑 path 가 필요함
		//아래 각각 메서드 생성해서 try catch 해주기
		
		String command = request.getParameter("command"); //form에서 command 값 받아올거얌
		String path = "index.jsp"; //index가 메인 페이지이니까
		
//			
//			try {
//				if(command.equals("register")) {
//					path = register(request, response);
//				}
//			} catch (ServletException e) {
//				e.printStackTrace();
//		
//				request.getRequestDispatcher(path).forward(request, response);
//			}
		
		
	
		
		
		
		
	}
	
	
	protected String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//1.폼값 받아오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		//폼값 vo에 넣기
		MemberVO vo = new MemberVO(id, password, name, address);
		
		//dao 메서드랑 합치기
		MemberDAO.getInstance().registerMember(vo);
		
		//값 넘기기
		return "index.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
