package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.vo.Member;

// @Service			: bean 등록 시 이름을 클래스명으로 등록(MemberServiceImpl)
// @Service("이름")	: bean 등록 시 이름을 지정된 이름으로 등록

@Service // Service 레이어, 비즈니스 로직을 가진 클래스임을 명시 + bean 등록
public class MemberServiceImpl implements MemberService {
	
	// spring-security.xml에서 등록한 bean을 의존성 주입(DI)
	@Autowired
	private BCryptPasswordEncoder bcrypt;


	// 로그인 서비스
	@Override
	public Member login(Member inputMember) {
		
		System.out.println("입력한 비밀번호 : " + inputMember.getMemberPw());
		System.out.println("암호화 비밀번호 : " + bcrypt.encode(inputMember.getMemberPw()) );
		
		// DAO 코드
		return null;
	}
	
	
}
