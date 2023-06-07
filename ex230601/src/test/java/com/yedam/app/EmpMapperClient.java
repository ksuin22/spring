package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {

	@Autowired
	EmpMapper empMapper; // 인터페이스를 상속받은 구현클래스를 주입받음.

	@Ignore
	public void getEmpInfo() { // 한건조회
		EmpVO findEmp = empMapper.selectEmp(100);
		assertEquals(findEmp.getFirstName(), "Steven"); // 두개값이 같은지 비교

	}

//	@Test
	public void getOne() { // 등록
		EmpVO vo = new EmpVO();
		vo.setEmployeeId("904");
		vo.setLastName("kim3");
		vo.setEmail("email22@email");
		vo.setHireDate("23/06/01");
		vo.setJobId("IT_PROG");
		int one = empMapper.insertEmp(vo);
		// insert 후에 empId를 사용하고자 할경우 mapper에 selectKey 씀
		System.out.println(vo.getDepartmentId());
		assertEquals(one, 1);
	}

	@Ignore
	public void getEmpList() { // 전체조회
		EmpVO param = new EmpVO();
		// param.setDepartmentId(null);
		// param.setDepartmentId("50,60");
		param.setFirstName("e");
		// param.setOrderColumn("first_name");
		List<EmpVO> list = empMapper.selectList(param);
		int count = empMapper.selectCount(param);
		for (EmpVO emp : list) {
			System.out.println(emp);
		}
		System.out.println("1>>   " + list);
		System.out.println(count);
		// assertEquals(list.get(0).getEmployeeId(), "100");

	}

	@Test
	public void selectJobs() {
		List<Map<String, Object>> list = empMapper.selectJobs();
		assertNotNull(list);
	}

}
