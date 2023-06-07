package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.EmpVO;

//매퍼 패키지 관련은 root-context에 있다. 

public interface EmpMapper {

	public List<EmpVO> selectList(EmpVO vo);
	public EmpVO selectEmp(int empNo);
	public int selectCount(EmpVO vo);
	public int insertEmp(EmpVO vo);//등록
	public int deleteEmp(int empNo);//삭제
	public int updateEmp(EmpVO vo);//삭제
	
	public List<Map<String,Object>> selectJobs();
	public List<Map<String,Object>> selectDept();
	

}
