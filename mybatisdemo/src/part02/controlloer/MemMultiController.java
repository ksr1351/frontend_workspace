package part02.controlloer;

import java.util.List;

import part02.dto.MemDTO;
import part02.service.MemService;

public class MemMultiController {

	private MemService service;

	public MemMultiController() {
		service = new MemService();
	}

	public int setInsertListExecute(List<MemDTO> memList) {
		return service.setInsertListProcess(memList);

	}

	public List<MemDTO> getAllListExecute() {
		return service.getAllListProcess();
	}

	public int setDeleteArrayExecute(int[] num) {
		return service.setDeleteArrayProcess(num);

	}

	public List<MemDTO> getPartSearchExecute(MemDTO dto) {
		return service.getPartSearchProcess(dto);
	}

	public int setUpdateMultiExecute(MemDTO dto) {
		return service.setUpdateMultiProcess(dto);
	}
	
	public int setInsertDataExcute(MemDTO dto) {
		return service.setInsertDataProcess(dto);
	}

}// end class
