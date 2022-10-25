package edu.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.vo.Member;

@Repository // �۽ý��Ͻ� ���̾�, ���Ӽ��� (����, DB)���� Ŭ���� + bean ��� 
public class MemberDAO {

	// DBCP + ���̹�Ƽ�� �̿� ��ü DI(������ ����)
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	
	
	/** �α��� DAO
	 * @param memberEmail
	 * @return loginMember
	 */
	public Member login(String memberEmail) {
		// 	   sqlSession.selectOne("�����̸�.�±�id",SQL �ۼ��� �ʿ��� ��);
		return sqlSession.selectOne("memberMapper.login",memberEmail);
	}

}