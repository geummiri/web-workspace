package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDAO;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String itemIdStr = request.getParameter("itemId");
		int itemId = Integer.parseInt(itemIdStr);

		
		Item item = ItemDAO.getInstance().getItem(itemId);
		
		
		if (item != null) {
		    request.setAttribute("item", item);
		    String path = "itemView.jsp";
		    return new ModelAndView(path);
		} else {
			return null;
		}
		
	}

}
