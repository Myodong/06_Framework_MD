package edu.kh.project.member.model.service;

import java.util.List;

import edu.kh.project.member.model.vo.Member;

// ���� �������̽� �� �������?
// ����, ���������� ���, AOP ������
public interface AjaxService {

	/** �̸��� �ߺ� �˻�
	 * @param memberEmail
	 * @return result
	 */
	int emailDupCheck(String memberEmail);

	/** �г��� �ߺ� �˻�
	 * @param memberNickname
	 * @return result
	 */
	int nicknameDupCheck(String memberNickname);

	/** �̸��Ϸ� ȸ������ ��ȸ
	 * @param email
	 * @return member
	 */
	Member selectEmail(String email);

	/** ȸ�� ��� ��ȸ
	 * @return
	 */
	List<Member> selectMemberList();

}
