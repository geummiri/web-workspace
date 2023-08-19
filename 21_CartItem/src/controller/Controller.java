package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//17번 패키지까지는 execute 메서드로 넘겼으나
	//이제부터는 모델이랑 뷰 넘김 
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
