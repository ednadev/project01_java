package encore.test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import encore.service.CurriculumServiceImpl;
import encore.service.StudentServiceImpl;
import encore.util.StringResource;
import encore.vo.Curriculum;
import encore.vo.Student;

public class EncoreServiceTest {
	static StringResource str = new StringResource();
	static int modeSelect = 0;
	static Scanner sc = new Scanner(System.in);
	static CurriculumServiceImpl cs = CurriculumServiceImpl.getInstance();
	static StudentServiceImpl ss = StudentServiceImpl.getInstance();
	
	
	public static void main(String[] args) {
		
		for(int i=0; i<5; i++) {
			Curriculum cd = new Curriculum();
			cd.setId(i+1);
			cd.setName("Java" + i);
			cd.setTerm(300+i);
			cs.add(cd);
		}
		for(int i=0; i<10; i++) {
			Student vo = new Student();
			vo.setId(i);
			vo.setName("ȫ�浿" + i);
			vo.setMajor("�ڹ�");
			vo.setPhone("0100000000"+i);
			vo.setCurriculum(cs.oneSearch(1));
			vo.setCheckOut(75+i);
			cs.oneSearch(1).setCntMember(cs.oneSearch(1).getCntMember()+1);
			ss.add(vo);
			
		}
		
		
		// 1. while��
		// 2. 1��. �л� / 2��. ���� - if��
		// 3. ������ 2�� �н�

		// 1. while��
		// 2. 1��. �л� / 2��. ���� - if��
		// 3. ��
		// 4. while��

		// �ź� ���� 1��. �л� / 2��.
		// 1�� �ϰ�� ������û, ��û��ȸ, ��û���� , ��û���
		// 2�� �ϰ�� �����ڵ� ����� ������ �н� Ʋ���� �ٽ� �ź� ���ø��
		// �ڵ� ������� �����߰�, ��ȸ, ����, ���
		// ��ȸ ��ü��ȸ�� �ٳ����� �ϰ� �Ʒ� �߰��� ������ȸ ���º���ȸ ���
		// ���� 1. ���� ���� 2. �л� ����
		// ����1. ���� ���� 2. �л� ����
		
		//������ 2.��ȸ > 1. �����ο� ��ȸ  2. ���ǰ˻� (�Ʒ��� 1.�̸�, 2. ��ȣ. 3.�⼮(1.��ü,2�̴�,3�հ�) 

		selectMod();
		while(true) {
			try {
				if (modeSelect == 1) {
					System.out.println(str.menuStu);
					switch (sc.nextInt()) {
					case 1:
						if(ss.add(studentAdd()) == 1) {
							System.out.println(str.comAdd);
						} 
						break;
					case 2:
						System.out.println(str.searchStudentName);
						String name = sc.next();
						System.out.println(str.searchStudentPhone);
						String phone = sc.next();
						if(ss.oneSearch(name, phone)!=null) {
							System.out.println(ss.oneSearch(name, phone).toString());
						}else {
							System.out.println(str.failedStudent);
						}
						break;
					case 3:
						System.out.println(str.updateStudent);
						int select = sc.nextInt();
						if(ss.oneSearch(select)==null) {
							System.out.println(str.failedStudent);
							break;
						}
						System.out.println(str.updateStudentList);
						switch(sc.nextInt()) {
						case 1:
							System.out.println(str.updateStudentMajor);
							ss.oneSearch(select).setMajor(sc.next());
							ss.update(0, ss.oneSearch(select));
							break;
						case 2:
							System.out.println(str.updateStudentPhone);
							ss.oneSearch(select).setPhone(sc.next());
							ss.update(0, ss.oneSearch(select));
							break;
						case 3:
							for(Object c : cs.search()) {
								System.out.println(((Curriculum)c).toString());
							}
							System.out.println(str.updateStudentCclum);
							// ������Ʈ �� ���ǿ� 1�߰�, ���� ���ǿ��� -1
							ss.oneSearch(select).getCurriculum().setCntMember(ss.oneSearch(select).getCurriculum().getCntMember()-1);
							int cclumNum = sc.nextInt();
							ss.oneSearch(select).setCurriculum(cs.oneSearch(cclumNum));
							
							cs.oneSearch(cclumNum).setCntMember(cs.oneSearch(cclumNum).getCntMember()+1);
							ss.oneSearch(select).getCurriculum().getCntMember();
							break;
						}
						break;					
					case 4:
						System.out.println(str.deleteStudent);
						int selectStudent = sc.nextInt();
						ss.oneSearch(selectStudent).getCurriculum().setCntMember(ss.oneSearch(selectStudent).getCurriculum().getCntMember()-1);
						if(ss.delete(selectStudent) == 1) {
							
							System.out.println(str.comDelete);
						} else {
							System.out.println(str.failedStudent);
						}
						break;
					case 5:
						selectMod();
						break;
					}
				} else {
					System.out.println(str.menuGm);
					switch (sc.nextInt()) {
					
					case 1:
						if(cs.add(add()) == 1) {
							System.out.println(str.comAdd);
						}else {
							System.out.println();
						}
						break;
						
					case 2:
						for(Object c : cs.search()) {
							System.out.println(((Curriculum)c).toString());
						}
						System.out.println(str.searchStudentList);
						switch(sc.nextInt()) {
						case 1:
							System.out.println(str.insertCode);
							int selectCode = sc.nextInt();
							for(Object o : ss.search()) {
								if(((Student) o).getCurriculum().getId() == selectCode) {
									System.out.println(((Student) o).toString());
									
								}
							}	
							break;
						case 2: 
							System.out.println(str.searchSelectCclum);
							switch(sc.nextInt()) {
							case 1:
								System.out.println(str.addStudent[0]);
								String insertName = sc.next();
								for(Object o : ss.search()) {
									if(((Student) o).getName().equals(insertName)) {
										System.out.println(((Student) o).toString());
									}
								}
								break;
							case 2:
								System.out.println(str.addStudent[2]);
								String insertPhone = sc.next();
								
								for(Object o : ss.search()) {
									if(((Student) o).getName().equals(insertPhone)) {
										System.out.println(((Student) o).toString());
									}
								}
								break;
							case 3:
								System.out.println(str.searchCheck);
								switch(sc.nextInt()) {
								case 1:
									for(Object o : ss.search()) {
										System.out.println(((Student) o).toString());
									}		
									break;
								case 2:
									for(Object o : ss.search()) {
										if(((Student) o).getCheckOut()<80) {
											System.out.println(((Student) o).toString());
										}
									}
									break;
								case 3:
									for(Object o : ss.search()) {
										if(((Student) o).getCheckOut()>=80) {
											System.out.println(((Student) o).toString());
										}
									}
									break;
								}
							}
							break;
						}
						break;

					case 3:
						for(Object c : cs.search()) {
							System.out.println(((Curriculum)c).toString());
						}
						System.out.println(str.selectUpdate);
						int select = sc.nextInt();
						if(cs.oneSearch(select)==null) {
							System.out.println(str.failedCclum);
							break;
						}
						System.out.println(str.updateCclum);
						switch (sc.nextInt()) {
						case 1:
							System.out.println(str.updateCclumName);
							cs.oneSearch(select).setName(sc.next());
							cs.update(0, cs.oneSearch(select));
							break;
						case 2:
							System.out.println(str.updateCclumTerm);
							cs.oneSearch(select).setTerm(sc.nextInt());
							cs.update(0, cs.oneSearch(select));
							break;
						case 3:
							System.out.println(str.updateCclumLan);
							for(int i=0; i<cs.oneSearch(select).getLanguage().size(); i++) {
								cs.oneSearch(select).getLanguage().set(i, sc.next());
							}
							break;
						}
						break;

					case 4:
						for(Object c : cs.search()) {
							System.out.println(((Curriculum)c).toString());
						}
						System.out.println(str.selectCclum);
						if(cs.delete(sc.nextInt()) == 1) {
							System.out.println(str.comDelete);
						} else {
							System.out.println(str.failedCclum);
						}
						break;
					case 5:
						selectMod();
						break;
					}
					
				}
				
			} catch (InputMismatchException e) {
				System.out.println(str.notstr);
				sc.nextLine();
			}
		}
		


	}

	public static void selectMod() {
		while (true) {
			try {
				System.out.println(str.strMode);

				modeSelect = sc.nextInt();

				if (modeSelect == 1) {
					break;
				} else {
					System.out.println(str.codeCheck);
					if (sc.next().equals(str.codeNum) ? true : false)
						break;
					System.out.println(str.notCode);
				}
			} catch (InputMismatchException e) {
				System.out.println(str.notstr);
				sc.nextLine();
			}
		}
	}
	
	public static Student studentAdd() {
		Student student = new Student();
		System.out.println(str.addStudent[0]);
		String name = sc.next();
		student.setName(name);
		System.out.println(str.addStudent[1]);
		String major = sc.next();
		student.setMajor(major);
		System.out.println(str.addStudent[2]);
		String phone = sc.next();
		Pattern telephone = Pattern.compile(str.regExp);
		Matcher m = telephone.matcher(phone); 

		while(true) {
			if (m.matches()){
				student.setPhone(phone);
				for(Object c : cs.search()) {
					System.out.println(((Curriculum)c).toString());
				}
				System.out.println(str.searchStudentCclum);
				int cclumNum = sc.nextInt();
				student.setCurriculum(cs.oneSearch(cclumNum));
				cs.oneSearch(cclumNum).setCntMember(cs.oneSearch(cclumNum).getCntMember()+1);
				return student;
			}else {
				System.out.println(str.failedPhone);
				break;
			}
		}
		
		
		
		return null;
	}
	
	public static Curriculum add() {
		Curriculum curriculum =null;
		System.out.println(str.addCurriculum[0]);
		String name = sc.next();
		System.out.println(str.addCurriculum[1]);
		int term = sc.nextInt();
		ArrayList<String> arr = new ArrayList<>();
		while (true) {
			System.out.println(str.addCurriculum[2]);
			String language = sc.next();
			if (language.equals("0")) {
				curriculum = new Curriculum();
				curriculum.setName(name);
				curriculum.setTerm(term);
				curriculum.setLanguage(arr);
				break;
			}
			arr.add(language);
		}
		return curriculum;
	}
}
