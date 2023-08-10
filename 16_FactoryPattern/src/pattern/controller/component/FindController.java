package pattern.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.controller.Controller;
import pattern.model.NoteBook;
import pattern.model.NoteBookDAO;


//마지막에는 FindController로 통합해서 사용함 -> 지금은 factory pattern으로 짜보는거
public class FindController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//비지니스 로직 들어오는 곳
		
		String path = "find_fail.jsp";
		String model = request.getParameter("model"); //find_notebook.html form에 있는 input값 가져오기
		NoteBook notebook = NoteBookDAO.getInstance().findNoteBook(model);
		
		if(notebook!=null) {
			request.setAttribute("notebook", notebook);
			path = "find_result.jsp";
		}
		
		return path;
	}

}
