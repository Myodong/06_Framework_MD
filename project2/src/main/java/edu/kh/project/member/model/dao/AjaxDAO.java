package edu.kh.project.member.model.dao;

import java.util.List;

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
	 * @return member
	 */
	public Member selectEmail(String email) {
		
		
		
		return sqlSession.selectOne("ajaxMapper.selectEmail",email);
	}




	/** ȸ�� ��� ��ȸ
	 * @return
	 */
	public List<Member> selectMemberList() {
		
		// selectList() :
		// ��ȸ ����� �� ���� resultType �Ǵ� resulMap�� �´� 
		// VO��ü�� ��� List�� �߰���
		return sqlSession.selectList("ajaxMapper.selectMemberList");
	}
	

}
