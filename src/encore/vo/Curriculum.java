package encore.vo;

import java.util.ArrayList;

public class Curriculum {
	private int id;
	private String name;
	private int term;
	ArrayList<String> language;
	private int cntMember;
	
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
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public ArrayList<String> getLanguage() {
		return language;
	}
	public void setLanguage(ArrayList<String> language) {
		this.language = language;
	}
	
	public int getCntMember() {
		return cntMember;
	}
	public void setCntMember(int cntMember) {
		this.cntMember = cntMember;
	}
	
	@Override
	public String toString() {
		return "�����ڵ�=" + id + "\t\t���¸�=" + name + "\t\t�����ϼ�=" + term + "\t\t���=" + language + "\t\t�����ο�=" + cntMember + "��";
	}

}
