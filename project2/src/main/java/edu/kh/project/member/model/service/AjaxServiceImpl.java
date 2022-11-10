package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.AjaxDAO;

@Service // ����Ͻ� ���� ó�� ���� + bean ���
public class AjaxServiceImpl implements AjaxService {

   @Autowired
   private AjaxDAO dao;
   
   //�̸��� �ߺ� �˻�
   @Override
   public int emailDupCheck(String memberEmail) {
      return dao.emailDupcheck(memberEmail);
   }
   
}
	
