package com.yedam.app.dept.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptMapper deptMapper;

	@Override
	public List<DeptVO> getDeptList() {
		return deptMapper.selectDeptList();
	}

	@Override
	public DeptVO getDeptOne(DeptVO vo) {
		return deptMapper.selectDeptOne(vo);
	}

	@Override
	public int insertDeptInfo(DeptVO vo) {
		int result = deptMapper.insertDeptInfo(vo);
		System.out.println("id: " + vo.getDepartmentId());
		return result;
	}

	@Override
	public Map<String, Object> updateDeptList(List<DeptVO> list) {
		Boolean result = false;
		List<Integer> successList = new ArrayList<>();
		int count = 0;
		for (DeptVO deptInfo : list) {
			int res = deptMapper.updateDeptInfo(deptInfo);
			if (res > 0) {
				// 0이아니면(=정상적으로 수정이 되었을 경우)
				count += 1;
				successList.add(deptInfo.getDepartmentId());
			}
		}
		if (count > 0) {
			result = true;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		map.put("success", count);
		map.put("deptList", successList);

		return map;
	}

	@Override
	public int deleteDeptList(List<DeptVO> list) {
		int count = 0;
		for (DeptVO deptInfo : list) {
			count += deptMapper.deleteDeptInfo(deptInfo.getDepartmentId());
		}
		return count;
	}

}
