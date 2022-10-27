package edu.kh.project.member.model.service;

import java.util.Map;

import edu.kh.project.member.model.vo.Member;

// ������ +�������� + AOP
public interface MyPageService {

	/** ȸ�� ���� ���� ����
	 * @param inputMember
	 * @return
	 */
	/* public abstract */ int updateInfo(Member inputMember);

	
	
	
	/** ��й�ȣ ���� ����
	 * @param paramMap
	 * @return
	 */
	int changePw(Map<String, Object> paramMap);

	
	
	/** ȸ�� Ż��
	 * @param memberNo
	 * @param memberPw
	 * @return 
	 */
	int memberDelete(int memberNo, String memberPw);

}
