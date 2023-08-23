package edu.kh.test.user.model.vo;

public class UserDTO {
	
	private int userNo;
	private String userId;
	private String userName;
	private int userAge;
	
	
	public UserDTO() {
		super();
	}


	public UserDTO(int userNo, String userId, String userName, int userAge) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
	}
	
}
