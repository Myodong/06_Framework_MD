package edu.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.vo.Member;

@Repository // DB �����ϴ� ���� + bean ���
public class AjaxDAO {
	
	@Autowired // ���� �ڷ����� bean���� ��ϵǾ� ������ �ڵ����� DI
	private SqlSessionTemplate sqlSession;
	// SqlSessionTemplate : Ŀ�ؼ� + ���̹�Ƽ�� + ������ TX���� �� �� �ִ� ��ü




	/** �̸��� �ߺ� �˻�
	 * @param memberEmail
	 * @return result
	 */
	public int emailDupcheck(String memberEmail) {
		return sqlSession.selectOne("ajaxMapper.emailDupCheck", memberEmail);
	}




	/** �г��� �ߺ� �˻�
	 * @param memberNickname
	 * @return result
	 */
	public int nicknameDupCheck(String memberNickname) {
		return sqlSession.selectOne("ajaxMapper.nicknameDupCheck",memberNickname);
	}




	/** �̸��Ϸ� ȸ������ ��ȸ
	 * @param email
	 * @return
	 */
	public Member selectEmail(String email) {
		
		
		
		return sqlSession.selectOne("ajaxMapper.selectEmail",email);
	}
	

}
