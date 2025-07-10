package kr.co.sist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.sist.intercetpros.TestInterceptor;
import kr.co.sist.intercetpros.TestInterceptor2;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Value("${myapp.addPath}")
	List<String> addPathAdminList;
	
	@Value("${myapp.excludePath}")
	List<String> excludePathAdminList;
	
	@Autowired
	private TestInterceptor ti;
	
	@Autowired
	private TestInterceptor2 ti2;

	/**
	 * 3. 제작된 interceptor 가 동작할 URI를 설정하여 등록
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//excludePathPattern 등록.
		registry.addInterceptor(ti).addPathPatterns(addPathAdminList)
		.excludePathPatterns(excludePathAdminList);
		
		//excludePathPattern 등록.
//		registry.addInterceptor(ti2).addPathPatterns(addPathAdminList)
//		.excludePathPatterns(excludePathAdminList);
	} //addInterceptors
	
} //class
