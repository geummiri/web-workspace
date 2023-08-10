package pattern.controller;

import pattern.controller.component.FindController;

public class ControllerFactory {
	//싱글톤 패턴
	
	private static ControllerFactory factory = new ControllerFactory();
	
	private ControllerFactory() {
		//다른곳에서 생성 못하게 private으로 작성
	}
	
	public static ControllerFactory getInstance() { 
		//생성자 대신 메서드를 다른곳에서 호출 가능하게 public으로 작성
		return factory;
	}
	
	
	//createController: 컨트롤러를 생성하는 기능
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("findModel")) {
			controller = new FindController();
			
		}
		return  controller;
	}
	
}
