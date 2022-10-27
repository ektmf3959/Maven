package com.yedam.java.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.java.emp.service.EmpService;
import com.yedam.java.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@RequestMapping("/allList")
	public String getEmpList(Model model) {
		model.addAttribute("empInfoList",
				empService.selectAllEmp());
		return "emp/empList";
	}
	
	@GetMapping("/info")
	public String getEmpInfo(EmpVO empVO, Model model) {
		EmpVO findEmp = empService.selectOneEmp(empVO);
		model.addAttribute("empInfo", findEmp);
		return "emp/empInfo";
	}
	
	@GetMapping("insertForm")
	public String printInsertForm() {
		return "emp/insertForm";
				
	}
	
	@PostMapping("insert")
	public String empInsert(EmpVO empVO, RedirectAttributes ratt) {
		int result = empService.insertEmpInfo(empVO);
		if(result == 1) {
			ratt.addFlashAttribute("msg","정상적으로 등록되었습니다.");
		}else {
			ratt.addAttribute("msg", "정상적으로 등록되지 않았습니다.");
		}
		return "redirect:allList";
	}
	
	@PostMapping("updateSal")
	public String empUpdateSal(@RequestParam int employeeId, RedirectAttributes ratt) {
		int result = empService.updateEmpSal(employeeId);
		if(result == 1) {
			ratt.addFlashAttribute("msg","정상적으로 등록되었습니다.");
		}else {
			ratt.addAttribute("msg", "정상적으로 등록되지 않았습니다.");
		}
		return "redirect:allList";
	}
	
	@GetMapping("delete/{empId}")
	@ResponseBody  //제이슨으로 받을게 아니면 안써도 무관함
	public String empDelete(@PathVariable int empId) { 
		//포맷이다름 키가 필요하냐(RequestParam) 필요하지 않느냐(pathvariable) 차이 
		int result = empService.deleteEmpInfo(empId);
		String message = null;
		if(result == 1) {
			message = "사원번호 : " + empId + "가 삭제되었습니다.";
		}else {
			message = "삭제되지 않았습니다.";
		}
		return message;
	}
}
	

