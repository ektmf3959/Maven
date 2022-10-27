package com.yedam.java.user.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.java.user.service.UserVO;

@Controller
public class UserController {

	@RequestMapping(value="inputForm", 
					method= {RequestMethod.POST, 
							 RequestMethod.GET})
	public String inputForm() {
		return "inputForm";
	}
	
	@RequestMapping("users")
	//public String process(UserVO uservo) {
	//public String process(@RequestParam("name") String userName,
	//					  @RequestParam("age") int userAge) {
	public String process(@RequestParam Map<String, Object> map) {
		System.out.println(map.get("name") + " , " + map.get("age"));
	//System.out.println("이름 : " + uservo.getName());
		//System.out.println("나이 : " + uservo.getAge());
		//System.out.println(userName + " , " + userAge);
		
		return "";
	}
	
	@RequestMapping("nameList")
	public String nameProcess(@RequestParam List<String> name) {
		for (String temp : name) {
			System.out.println(temp);
		}
		return "";
	}
	
	
	@RequestMapping(value="userList")
	//public String listProcess(UserListVO userList) {
	public String listProcess(@RequestBody List<UserVO> userList) {
		for(UserVO uservo : userList) {
			System.out.println("이름 : " + uservo.getName());
			System.out.println("나이 : " + uservo.getAge());
		}
		return "";
	}
}
