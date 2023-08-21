package model.vo;

public class StudentVO {
	private int studentNo;
	private String studentName;
	private String studentAddress;
	
	//다른 객체 가져오기
	private DepartmentVO department;


	public StudentVO() {
		super();
	}

	public int getStudentNo() {
		return studentNo;
	}


	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudentAddress() {
		return studentAddress;
	}


	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}


	public DepartmentVO getDepartment() {
		return department;
	}


	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}


	public StudentVO(int studentNo, String studentName, String studentAddress, DepartmentVO department) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.department = department;
	
	}
	
}
