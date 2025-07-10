package kr.co.sist.intercetpros;

import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 
 */
@Component
public class TestInterceptor2 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle 요청 URL : "+ request.getRequestURI());
		System.out.println("1번 TestInterceptor2 preHandle 호출 : handlerMapper 호출 전 실행 ");
		
		boolean flag = new Random().nextBoolean();
		if(flag) {
			response.sendRedirect("http://localhost:8080/error.html");
		} //end if
		
		return flag;
	} //preHandle

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("2번 TestInterceptor2 postHandle 호출 : View(Jsp, HTML)가 호출, 생성 전 실행");
	} //postHandle

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("3번 TestInterceptor2 afterCompletion 호출 : View 응답 전 실행");
	} //afterCompletion

} //class
