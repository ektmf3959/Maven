package com.yedam.java.emp.service;

import java.util.List;

public interface EmpService {
	//전체조회
	public List<EmpVO> selectAllEmp();
	//단건조회
	public EmpVO selectOneEmp(EmpVO empVO);
	//등록
	public int insertEmpInfo(EmpVO empVO);
	//수정
	public int updateEmpSal(int empId);
	//삭제
	public int deleteEmpInfo(int empId);
}
