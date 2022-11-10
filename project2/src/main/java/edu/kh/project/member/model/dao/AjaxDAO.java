package edu.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // DB �����ϴ� ���� + bean ���
public class AjaxDAO {
	
	@Autowired // ���� �ڷ����� bean���� ��ϵǾ� ������ �ڵ����� DI
	private SqlSessionTemplate sqlSession;
	// SqlSessionTemplate : Ŀ�ؼ� + ���̹�Ƽ�� + ������ TX���� �� �� �ִ� ��ü




	public int emailDupcheck(String memberEmail) {
		return sqlSession.selectOne("ajaxMapper.emailDupCheck", memberEmail);
	}
	

}
