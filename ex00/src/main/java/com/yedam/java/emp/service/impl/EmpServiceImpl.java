package com.yedam.java.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.emp.mapper.EmpMapper;
import com.yedam.java.emp.service.EmpService;
import com.yedam.java.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpMapper empMapper;
	
	@Override
	public List<EmpVO> selectAllEmp() {
		return empMapper.getEmpList();
	}

	@Override
	public EmpVO selectOneEmp(EmpVO empVO) {
		return empMapper.getEmp(empVO);
	}

	@Override
	public int insertEmpInfo(EmpVO empVO) {
		return empMapper.insertEmp(empVO);
	}

	@Override
	public int updateEmpSal(int empId) {
		// TODO Auto-generated method stub
		return empMapper.updateEmpSalary(empId);
	}

	@Override
	public int deleteEmpInfo(int empId) {
		// TODO Auto-generated method stub
		return empMapper.deleteEmpInfo(empId);
	}

}
