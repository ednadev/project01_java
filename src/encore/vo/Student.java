package encore.vo;

public class Student {
	private int id;
	private String name;
	private String major;
	private String phone;
	private int checkOut;
	private Curriculum curriculum;
	
	
	public Student() {
	}
	public Student(int id, String name, String major, String phone, int checkOut, Curriculum curriculum) {
		this.id = id;
		this.name = name;
		this.major = major;
		this.phone = phone;
		this.checkOut = checkOut;
		this.curriculum = curriculum;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(int checkOut) {
		this.checkOut = checkOut;
	}
	public Curriculum getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
	
	@Override
	public String toString() {
		return "�л��ڵ�=" + id + "\t\t�л��̸�=" + name + "\t\t����=" + major + "\t\t�ڵ�����ȣ=" + phone + "\t\t�⼮üũ="
				+ checkOut + "%\t\t�����ϴ°���=" + curriculum.getName();
	}
	
}
