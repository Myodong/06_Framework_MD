package edu.kh.project.member.model.service;

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
	 * @return
	 */
	Member selectEmail(String email);

}
