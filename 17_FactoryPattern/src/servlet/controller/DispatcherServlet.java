package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		String path = "error.jsp";
		
		Controller controller = ControllerFactory.getInstance().createController(command);
		
		try {
			path = controller.execute(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String command = request.getParameter("command");
//		String path = "error.jsp";
//		
//		Controller controller = ControllerFactory.getInstance().createController(command);
//		
//		try {
//			path = controller.execute(request, response);
//		} catch (Exception e) {}
//	
//		request.getRequestDispatcher(path).forward(request, response);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
