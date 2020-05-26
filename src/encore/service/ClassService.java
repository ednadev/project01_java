package encore.service;

import java.util.ArrayList;

public interface ClassService {
	public int maxId();
	public int add(Object vo);
	public int delete(int id);
	public int update(int id, Object vo);
	public ArrayList<Object> search();
}
