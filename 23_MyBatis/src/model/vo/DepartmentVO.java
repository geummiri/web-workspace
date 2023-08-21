package model.vo;

public class DepartmentVO {
	private int departmentNo;
	private String departmentName;
	private String category;
	
	
	public DepartmentVO() {
		super();
	}

	public DepartmentVO(int departmentNo, String departmentName, String category) {
		super();
		this.departmentNo = departmentNo;
		this.departmentName = departmentName;
		this.category = category;
	}

	public int getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "DepartmentVO [departmentNo=" + departmentNo + ", departmentName=" + departmentName + ", category="
				+ category + "]";
	}
	
}
