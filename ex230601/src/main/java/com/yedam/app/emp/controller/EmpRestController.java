package com.yedam.app.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RestController // 해당 컨트롤러의 모든 메서드는 데이터를 반환한다. @ReponseBody 안해도됨.
				// 페이지를 요청할수 없다. 데이터를 반환하는 경우에만 가능.
public class EmpRestController {

	@Autowired
	EmpMapper empMapper;

	// 전체조회
	@GetMapping("emps")
	public List<EmpVO> getEmpList() {
		EmpVO empVO = new EmpVO();
		return empMapper.selectList(empVO);
	}

	// 단건조회
	@GetMapping("emps/{empolyeeId}") // 변수명 같을경우 생략가능
	public EmpVO getEmpInfo(@PathVariable(name = "empolyeeId") int employeeId) {
		return empMapper.selectEmp(employeeId);
	}

	// 등록
	@PostMapping("emps")
	public EmpVO insertEmpInfo(@RequestBody EmpVO empVO) {
		empMapper.insertEmp(empVO);
		return empVO;
	}

	// 수정
	@PutMapping("emps/{employeeId}")
	public EmpVO updateEmpInfo(@PathVariable String employeeId, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);
		empMapper.updateEmp(empVO);
		return empVO;
	}

	// 삭제
	@DeleteMapping("emps/{employeeId}")
	public Map<String, Object> deleteEmpInfo(@PathVariable int employeeId) {
		boolean success = false;
		int result = empMapper.deleteEmp(employeeId);
		if (result > 0) {
			success = true;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("result", success);
		map.put("employee_id", employeeId);
		return map;
	}

}
