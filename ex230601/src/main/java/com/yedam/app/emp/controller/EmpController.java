package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

/* * command
 * POJO: 상속 필요없음.*/

/* @Controller의 역할
 * 객체생성해서 컨테이너에 빈을 등록하고 스프링 디스패처 서블릿에서 
 * 호출할수 있도록 커맨드 타입으로 만들어줌. @Component 상속받음.*/

@Controller
public class EmpController {

	@Autowired
	EmpMapper empMapper;

	@GetMapping("empList")
	public String empList(Model model, @ModelAttribute("emp") EmpVO vo) {
		System.out.println(vo);
		// vo = new EmpVO();
		// model.addAttribute("empVO",vo);
		model.addAttribute("empList", empMapper.selectList(vo));
		return "emp/empList";

	}

	// 사원등록 페이지로 이동
	@GetMapping("empInsert")
	public String empInserForm(Model model) {
		model.addAttribute("jobs", empMapper.selectJobs());
		model.addAttribute("dept", empMapper.selectDept());
		return "emp/empInsert";

	}

	// 사원등록 처리
	@PostMapping("empInsert")
	public String empInsert(EmpVO vo) {
		empMapper.insertEmp(vo);
		System.out.println(vo);
		return "redirect:empList";
	}

	// 사원삭제 처리
	@GetMapping("empDelete")
	public String empDelete(@RequestParam int empId) { //@리퀘스트파람 생략가능
		//int empId= request.getParameter("empId")
		empMapper.deleteEmp(empId);
		return "redirect:empList";
	}

	//사원 수정페이지로 이동
	@GetMapping("empUpdate")
	public String empUpdateForm(Model model, int empId) {
		model.addAttribute("emp", empMapper.selectEmp(empId));
		model.addAttribute("jobs", empMapper.selectJobs());
		model.addAttribute("dept", empMapper.selectDept());
		return "emp/empUpdate";

	}
	
	// 사원수정 처리
	@PostMapping("empUpdate")
	public String empUpdate(EmpVO vo) {
		empMapper.updateEmp(vo);
		System.out.println(vo);
		return "redirect:empList";
	}
	
	
	
}
