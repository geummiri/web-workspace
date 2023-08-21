package controller;

import controller.component.FindController;

//Factory 라는 이름을 지었지만 Handler와 동일
public class HandlerMapping {
	//싱글톤 패턴 작성해주기
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("find.do")){
			controller = new FindController();
		} 
		
		return controller;
	}
	
}
