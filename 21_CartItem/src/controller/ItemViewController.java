package controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDAO;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//오늘 본 상품정보를 저장하는 쿠키 로직
		
		int itemId = Integer.parseInt(request.getParameter("id"));
		Item item = ItemDAO.getInstance().getItem(itemId);
		
		
		ItemDAO.getInstance().updateRecordCount(itemId);
		
	
		
		//1) 쿠키생성 키,밸류 값 생성/키값은 String이여야함 
		//내가 오늘 본 상품들에는 url만 들어가게끔 쿠키에 만들기
		Cookie cookie = new Cookie("fruit-" + itemId, item.getPictureUrl());
		//쿠키는 시간이 필요함
		cookie.setMaxAge(60*60*24);
		//2) 생성한 쿠키를 웹브라우저로 보냄
		//위에서 생성한 쿠키 저장해주기
		//웹브라우저 -> 검사 -> application -> cookie 에서 값 확인가능
		response.addCookie(cookie);
		
	
		if (item != null) {
		    request.setAttribute("item", item);
		} 
		
		String path = "itemView.jsp";
		return new ModelAndView(path);
	}

}
