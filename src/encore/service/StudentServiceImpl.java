package encore.service;

import java.util.ArrayList;
import java.util.Random;

import encore.vo.Student;

public class StudentServiceImpl implements ClassService {

	private static StudentServiceImpl stuImpl = new StudentServiceImpl();
	private ArrayList<Object> arrStudent = new ArrayList<>();
	private int nextId = 1;
	private Random r = new Random();
	
	public static StudentServiceImpl getInstance() {
		return stuImpl;
	}
	
	@Override
	public int maxId() {
		return nextId++;
	}
	
	@Override
	public int add(Object vo) {
		if(vo!=null) {
			((Student) vo).setId(maxId());
			((Student) vo).setCheckOut(r.nextInt(40)+60);
			arrStudent.add(vo);
			return 1;
		}
		return -1;
	}

	@Override
	public int delete(int id) {
		for(int i=0; i<arrStudent.size(); i++) {
			if(((Student) arrStudent.get(i)).getId() == id) {
				arrStudent.remove(i);
				return 1;
			}
		}
		return -1;
	}

	@Override
	public int update(int id, Object vo) {
		for(int i=0; i<arrStudent.size(); i++) {
			if(((Student) arrStudent.get(i)).getId() == id) {
				arrStudent.set(i, vo);
				return 1;
			}
		}
		return -1;
	}

	@Override
	public ArrayList<Object> search() {
		return arrStudent;
	}

	public Student oneSearch(String name, String phone) {
		Student student = null;
		for(int i=0; i<arrStudent.size(); i++) {
			if(((Student) arrStudent.get(i)).getName().equals(name) 
					&& ((Student) arrStudent.get(i)).getPhone().equals(phone)) {
				return ((Student) arrStudent.get(i));
			}
 		}
		return student;
	}
	
	public Student oneSearch(int id) {
		Student student = null;
		for(int i=0; i<arrStudent.size(); i++) {
			if(((Student) arrStudent.get(i)).getId() == id) {
				return ((Student) arrStudent.get(i));
			}
 		}
		return student;
	}
}
