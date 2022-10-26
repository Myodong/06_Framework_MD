package edu.kh.project.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// ���� ó���� ��Ʈ�ѷ�
@ControllerAdvice
public class ExceptionController {

	/* ������ ���� ó�� ��� (3����, �ߺ���� ����)
	 * 
	 * 1���� : try-catch / throws ����ó�� ����
	 * 			-> �޼��� ������ ó��
	 * 
	 * 2���� : @ExceptionHandler ������̼�
	 * 			-> Ŭ���� ������ ó�� 
	 * 			- �ϳ��� ��Ʈ�ѷ����� �߻��ϴ� ���ܸ�
	 * 			  �ϳ��� �޼��忡 ��Ƽ� ó��
	 * 
	 * 3���� : @ControllerAdvice ������̼�
	 * 			-> ����(�� ���ø����̼�)���� �߻��ϴ� ���ܸ� ��Ƽ� ó��
	 * 			-���� Ŭ������ �ۼ�
	 */
	
		
		// ������Ʈ ���ο��� �߻��ϴ� ��� ���� ó��
		@ExceptionHandler(Exception.class)
		public String exceptionHandler(Exception e, Model model) {
			
			// �Ű����� Exception e : �߻��� ���� ���� ���� �Ű�����
			e.printStackTrace();
			
			model.addAttribute("errorMessage", "���� �̿� �� ������ �߻��߽��ϴ�.");
			model.addAttribute("e",e);
			
			return "common/error";
		}
		
/*
		//���ܺ��� �������� ó������
		@ExceptionHandler(RuntimeException.class)
		public String exceptionHandler(Exception e, Model model) {
			
			// �Ű����� Exception e : �߻��� ���� ���� ���� �Ű�����
			e.printStackTrace();
			
			model.addAttribute("errorMessage", "���� �̿� �� ������ �߻��߽��ϴ�.");
			model.addAttribute("e",e);
			
			
			return "common/error";
		}
*/
		
		
		
}
