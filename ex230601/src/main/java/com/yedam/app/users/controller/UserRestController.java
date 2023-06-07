package com.yedam.app.users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.users.service.UserVO;

//@Controller
@RestController // 해당 컨트롤러의 모든 메서드는 데이터를 반환한다. @ReponseBody 안해도됨.
				// 페이지를 요청할수 없다. 데이터를 반환하는 경우에만 가능.
public class UserRestController {

	@PostMapping("insertUser")
	// @ResponseBody // 데이터를 반환하는 메서드.
	public UserVO inserUSer(UserVO userVO) {
		System.out.println("name: " + userVO.getName());
		System.out.println("age : " + userVO.getAge());
		return userVO;
	}

	@GetMapping("getHome")
	public String getHome() {
		return "hoggggme";
	}

}
