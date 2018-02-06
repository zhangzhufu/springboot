package com.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.springboot.interceptor.MyInterceptor1;
import com.springboot.interceptor.MyInterceptor2;

/*
 *  web 配置
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	/*
	 * 拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
		registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	/*
	 * 静态资源
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 可以多次使用 addResourceLocations 添加目录，优先级先添加的高于后添加的。
		registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
		registry.addResourceHandler("/myimgs/**").addResourceLocations("file:H:/myimgs/");
		super.addResourceHandlers(registry);
	}
}
