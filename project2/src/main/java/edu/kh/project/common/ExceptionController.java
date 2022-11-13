package edu.kh.project.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 예외 처리용 컨트롤러
@ControllerAdvice
public class ExceptionController {

	/* 스프링 예외 처리 방법 (3종류, 중복사용 가능)
	 * 
	 * 1순위 : try-catch / throws 예외처리 구문
	 * 			-> 메서드 단위로 처리
	 * 
	 * 2순위 : @ExceptionHandler 어노테이션
	 * 			-> 클래스 단위로 처리 
	 * 			- 하나의 컨트롤러에서 발생하는 예외를
	 * 			  하나의 메서드에 모아서 처리
	 * 
	 * 3순위 : @ControllerAdvice 어노테이션
	 * 			-> 전역(웹 애플리케이션)에서 발생하는 예외를 모아서 처리
	 * 			-별도 클래스로 작성
	 */
	
		
		// 프로젝트 내부에서 발생하는 모든 예외 처리
		@ExceptionHandler(Exception.class)
		public String exceptionHandler(Exception e, Model model) {
			
			// 매개변수 Exception e : 발생한 예외 전달 받은 매개변수
			e.printStackTrace();
			
			model.addAttribute("errorMessage", "서비스 이용 중 문제가 발생했습니다.");
			model.addAttribute("e",e);
			
			return "common/error";
		}
		
/*
		//예외별로 나눠서도 처리가능
		@ExceptionHandler(RuntimeException.class)
		public String exceptionHandler(Exception e, Model model) {
			
			// 매개변수 Exception e : 발생한 예외 전달 받은 매개변수
			e.printStackTrace();
			
			model.addAttribute("errorMessage", "서비스 이용 중 문제가 발생했습니다.");
			model.addAttribute("e",e);
			
			
			return "common/error";
		}
*/
		
		
		
}