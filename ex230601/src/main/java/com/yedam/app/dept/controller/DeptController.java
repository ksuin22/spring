package com.yedam.app.dept.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.yedam.app.dept.service.DeptListVO;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Controller
public class DeptController {

	@Autowired
	DeptService deptService;

	// 경로 <-> 기능(view)
	// 경로 + 메소드 -> Unique

	// 조회(데이터, 페이지) -> get
	// 등록,수정,삭제 -> post
	// model : request, response를 편하게 쓰기 위한 ...

	// 전체조회 - 페이지
	@GetMapping("deptList")
	public String getDeptList(@RequestParam(required = false) String msg, Model model, HttpServletRequest request) {
		model.addAttribute("deptList", deptService.getDeptList());
		System.out.println("redirect: " + msg);
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) {
			System.out.println("departmentId: " + flashMap.get("departmentId"));
		}
		return "dept/deptList";
	}

	// 단건조회 페이지 -get
	@GetMapping("deptInfo")
	public String getDeptOne(DeptVO deptVO, Model model) {
		DeptVO vo = deptService.getDeptOne(deptVO);
		model.addAttribute("deptInfo", vo);
		return "dept/deptInfo";
	}

	// 등록페이지 -get
	@GetMapping("deptInsert")
	public String insertDeptForm() {
		return "dept/deptInsert";
	}

	// 등록기능 -post
	@PostMapping("deptInsert")
	public String inserDept(DeptVO deptVO, RedirectAttributes rtt) {
		deptService.insertDeptInfo(deptVO);
		rtt.addFlashAttribute("departmentId", deptVO.getDepartmentId());
		rtt.addAttribute("msg", "test"); // ?msg=test
		// return "redirect:deptList?departmentID=" + deptVO.getDepartmentId();
		return "redirect:deptList";
	}

	// 삭제기능 -post
	@PostMapping("deptDelete")
	public String deleteDept(DeptListVO list) {
		int result = deptService.deleteDeptList(list.getDeptList());
		return "redirect: deptList?msg=" + result;
	}

	// 수정기능 -post
	// @RequestBody는 json 포맷을 사용하는 경우. -> content-type: 'application/json' 해주기

//	@PostMapping("deptUpdate") // json 포맷을 사용하는 경우
//	public String updateDept(@RequestBody List<DeptVO> list, RedirectAttributes rtt) {
//		Map<String,Object> map = deptService.updateDeptList(list);
//		System.out.println(list);
//		rtt.addFlashAttribute("updateRes",map);
//		return "redirect:deptInfo?departmentId="+list.get(0).getDepartmentId();
//	}

//	@PostMapping("deptUpdate")
	@ResponseBody
	public Map<String, Object> deptUpdate(@RequestBody List<DeptVO> list) {
		return deptService.updateDeptList(list);
	}

	@PostMapping("deptUpdate")
	@ResponseBody
	public String deptUpdateText(@RequestBody List<DeptVO> list) {
		Map<String, Object> map = deptService.updateDeptList(list);
		return "success";
	}

}
