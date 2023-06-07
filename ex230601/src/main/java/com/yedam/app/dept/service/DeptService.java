package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


public interface DeptService {

	// 전체조회
	public List<DeptVO> getDeptList();

	// 단건조회
	public DeptVO getDeptOne(DeptVO vo);

	// 등록
	public int insertDeptInfo(DeptVO vo);

	// 수정
	public Map<String, Object> updateDeptList(List<DeptVO> list);

	// 삭제
	public int deleteDeptList(List<DeptVO> list);

}
