package com.yedam.app.dept.mapper;

import java.util.List;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	
	//전체조회
	public List<DeptVO> selectDeptList(); 
	
	//단건조회
	public DeptVO selectDeptOne(DeptVO vo);
	
	//등록
	public int insertDeptInfo(DeptVO vo);
	
	//수정
	public int updateDeptInfo(DeptVO vo);
	
	//삭제
	public int deleteDeptInfo(int deptNo);
	
}
