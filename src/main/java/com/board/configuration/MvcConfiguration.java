package com.board.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.board.interceptor.MemberLoginInterceptor;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
		
	@Autowired
	MemberLoginInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(interceptor).addPathPatterns("/board/**").excludePathPatterns("/board/list"); 
		
	}

}
