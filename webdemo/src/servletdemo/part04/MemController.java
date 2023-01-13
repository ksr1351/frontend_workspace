package servletdemo.part04;

import java.util.HashMap;
import java.util.List;

public class MemController {

	private MemService service;

	public MemController() {
		service = new MemService();
	}

	public List<MemDTO> listProcess() {
		return service.getMemList();
	}

	public int insertProcess(String name, int age, String loc) {
		MemDTO dto = new MemDTO(name, age, loc);
		return service.getInsert(dto);
	}

	public int updateProcess(int num, String name, int age, String loc) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		map.put("name", name);
		map.put("age", age);
		map.put("loc", loc);
		return service.getUpdate(map);

	}
	
	public int deleteProcess(int num) {
		return service.getDelete(num);
	}
	
	
	
	
}// end class
