package edu.kh.project.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.service.MyPageService;
import edu.kh.project.member.model.vo.Member;

// Ŭ���� ������ �ۼ���  @RequestMapping
// -> ��û�ּ��� �տ� ����� �κ��� �ۼ��Ͽ�
//    �ش� ���� ��û�� ��� �޾Ƶ��δٰ� �˸�
@RequestMapping("/member/myPage") // ����κ� �ּ�

@Controller // bean ���
public class MyPageController {

	@Autowired
	private MyPageService service;
	
	// �� ���� ������ �̵�
	@GetMapping("/info") // ������ �ּ� �强
	public String info() {
		return "member/myPage-info";
	}
	
	
	// �� ���� ����
	@PostMapping("/info")
	public String updateInfo(Member inputMember,
							 String[] memberAddress,
							 @SessionAttribute("loginMember") Member loginMember,
							 RedirectAttributes ra) {
	
		// inputMember : �Է� ���� memberNickname / memberTel / memberAddress(���� �ʿ�)
		// memberAddress : �Էµ� �����ȣ, �ּ�, ���ּҰ� ���迭
		
		// @SessionAttribute("loginMember") Member loginMember
		//	-> session�� �Ӽ� �� "loginMember"�� Ű�� ������ ����
		// 	   �Ű������� ����
		
		// ���� ���
		//HttpSession session = req.getSession();
		//Member loginMember = (Member)session.getAttribute("loginMember");
		
		
		// 1. �α��ε� ȸ�� �������� ȸ�� ��ȣ�� ���� inputMember�� ����
		inputMember.setMemberNo(loginMember.getMemberNo());
		
		// 2. inputMemeber.memberAddress�� ���� ���� �����ϱ�
		if(inputMember.getMemberAddress().equals(",,")) { // �ּ� ���ۼ�
			inputMember.setMemberAddress(null);
			
		} else {
			String address = String.join(",,", memberAddress);
			inputMember.setMemberAddress(address);
		}
		
		// ȸ�� ���� ���� ���� ȣ�� �� ��� ��ȯ �ޱ�
		int result = service.updateInfo(inputMember);
		
		String message =null;
		
		if(result > 0) {
			message ="ȸ�� ������ �����Ǿ����ϴ�.";
			
			// DB - session ����ȭ �۾�
			loginMember.setMemberNickname(	inputMember.getMemberNickname());
			loginMember.setMemberTel(		inputMember.getMemberTel());
			loginMember.setMemberAddress(	inputMember.getMemberAddress());
		} else {
			message ="ȸ�� ���� ���� ����....";
		}		   
		
		
		ra.addFlashAttribute("message",message);
		
		return "redirect:info"; // �� ���� ���û
	}
		
	// ��й�ȣ ���� ������ �̵�
	@GetMapping("/changePw")
	public String changePw() {
		return"member/myPage-changePw";
	}
	
	
	// ��й�ȣ ����
	@PostMapping("/changePw")
	public String changePw(@SessionAttribute("loginMember") Member loginMember,
						   //String currentPw, String newPw //��� 1 �Ķ���� ���� ���� �ޱ�
						   @RequestParam Map<String,Object> paramMap, // ���2
						   RedirectAttributes ra) {
		
		// @RequestParam Map<String,Object> paramMap
		// - ��� �Ķ���͸� �� �������� ���� ����
		
		// 1. loginMember���� ȸ�� ��ȣ�� ���� paramMap�� �߰�
		paramMap.put("memberNo", loginMember.getMemberNo());
		
		// 2. ���� ȣ�� �� ��� ��ȯ �ޱ�
		int result = service.changePw(paramMap);
		
		String path = null;
		String message = null;
		
		if (result > 0) { // ����
			path="info";
			message = "��й�ȣ�� ����Ǿ����ϴ�.";
			
		} else { // ����
			path ="changePw";
			message = "���� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
		}
		
		ra.addFlashAttribute("message", message);
		
		return "redirect:" + path;
	}
	
}
