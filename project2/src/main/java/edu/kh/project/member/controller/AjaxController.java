package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.project.member.model.service.AjaxService;

@Controller // ��û -> �˸��� ���� -> ��� ��ȯ -> �˸��� view ���� ����� + bean ���
public class AjaxController {
	
	@Autowired
	private AjaxService service;

	   //�̸��� �ߺ� �˻�
	   @GetMapping("/emailDupCheck")
	   @ResponseBody // ��ȯ�� ���� jsp ��ΰ� �ƴ� �� ��ü�� �ν�
	   public int emailDupCheck(String memberEmail) {
	             // data : {"memberEmail" : memberEmail.value}
	      
//	      System.out.println(memberEmail);
		      
		      // �̸��� �ߺ��˻� ���� ȣ��
		      int result = service.emailDupCheck(memberEmail);
		      
		      // @ResponseBody ������̼� ���п�
		      // result�� View Resolver�� ���޵��� �ʰ�
		      // ȣ���ߴ� ajax �Լ��� ��ȯ��
		      return result;
		   }


}
      
