package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.vo.Member;

// @Service			: bean ��� �� �̸��� Ŭ���������� ���(MemberServiceImpl)
// @Service("�̸�")	: bean ��� �� �̸��� ������ �̸����� ���

@Service // Service ���̾�, ����Ͻ� ������ ���� Ŭ�������� ��� + bean ���
public class MemberServiceImpl implements MemberService {
	
	// spring-security.xml���� ����� bean�� ������ ����(DI)
	@Autowired
	private BCryptPasswordEncoder bcrypt;


	// �α��� ����
	@Override
	public Member login(Member inputMember) {
		
		System.out.println("�Է��� ��й�ȣ : " + inputMember.getMemberPw());
		System.out.println("��ȣȭ ��й�ȣ : " + bcrypt.encode(inputMember.getMemberPw()) );
		
		// DAO �ڵ�
		return null;
	}
	
	
}
