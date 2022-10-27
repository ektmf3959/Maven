package co.micol.prj.member.service;

import lombok.Data;

@Data
public class MemberVO { //DTO
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberTel;
	private String memberAuthor;
	
}
