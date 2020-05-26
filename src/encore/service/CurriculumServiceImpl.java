package encore.service;

import java.util.ArrayList;

import encore.vo.Curriculum;

public class CurriculumServiceImpl implements ClassService {

	private static CurriculumServiceImpl csImpl = new CurriculumServiceImpl();
	private ArrayList<Object> arrCurriculum = new ArrayList<>();
	private int nextId = 1;
	public static CurriculumServiceImpl getInstance() {
		return csImpl;
	}
	
	@Override
	public int maxId() {
		return nextId++;
	}
	
	@Override
	public int add(Object vo) {
		if(vo!=null) {
			((Curriculum) vo).setId(maxId());
			arrCurriculum.add(vo);
			return 1;
		}
		return -1;
	}

	@Override
	public int delete(int id) {
		for (int i=0; i<arrCurriculum.size(); i++) {
			if(((Curriculum) arrCurriculum.get(i)).getId() == id) {
				arrCurriculum.remove(i);
				return 1;
			}
		}
		return -1;
	}

	@Override
	public int update(int id, Object vo) {
		for (int i=0; i<arrCurriculum.size(); i++) {
			if(((Curriculum) arrCurriculum.get(i)).getId() == id) {
				arrCurriculum.set(i, vo);
				return 1;
			}
		}
		return -1;
	}

	@Override
	public ArrayList<Object> search() {
		return arrCurriculum;
	}
	
	public Curriculum oneSearch(int id) {
		Curriculum cCulum = null;
		for (int i=0; i<arrCurriculum.size(); i++) {
			if(((Curriculum) arrCurriculum.get(i)).getId() == id) {
				return ((Curriculum) arrCurriculum.get(i));
			}
		}
		return cCulum;
	}

}
