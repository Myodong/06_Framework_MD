package edu.kh.project.member.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.MyPageDAO;
import edu.kh.project.member.model.vo.Member;

@Service // bean ���
public class MyPageServiceImpl implements MyPageService {

	
	@Autowired // DI(������ ����)
	private MyPageDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	
	
	// ȸ�� ���� ���� ����
	@Transactional
	@Override
	public int updateInfo(Member inputMember) {
		int result = dao.updateInfo(inputMember);
		
		return result;
	}

	
	
	// ��й�ȣ ���� ����
	@Transactional
	@Override
	public int changePw(Map<String, Object> paramMap) {
		// ���� ��й�ȣ ��ġ �� �� ��й�ȣ����
		
		// 1. ȸ�� ��ȣ�� �̿��ؼ� DB���� ��ȣȭ�� ��й�ȣ�� ��ȸ
		String encPw = dao.selectEncPw((int)paramMap.get("memberNo"));
		
		// 2. matches(�Է�PW, ��ȣȭPW) ����� true�� ���
		//    �� ��й�ȣ�� UPDATE�ϴ� DAO�ڵ带 ȣ��
		if (bcrypt.matches((String)paramMap.get("currentPw"), encPw)) {
			
			// �� ��й�ȣ ��ȣȭ
			String newPw =bcrypt.encode((String)paramMap.get("newPw")); 
			
			paramMap.put("newPw", newPw);
			// paramMap�� �����ϴ� ���� "newPw"�� ���� ����
			
			
			// DAO ȣ��
			int result = dao.changePw(paramMap);
			
			return result;
		}
		
		return 0; // ��й�ȣ ����ġ �� 0 ��ȯ
	}
	
	
	
}
