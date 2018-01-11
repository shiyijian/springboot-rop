package com.center.ropcenter;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

@RestController
@SpringBootApplication
@ImportResource("classpath:spring/applicationContext.xml")
@EnableTransactionManagement
@ServletComponentScan
public class RopCenterApplication {

	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

		servletRegistrationBean.addInitParameter("allow","127.0.0.1");
		servletRegistrationBean.addInitParameter("deny","");
		servletRegistrationBean.addInitParameter("loginUsername","druid");
		servletRegistrationBean.addInitParameter("loginPassword","druid");
		servletRegistrationBean.addInitParameter("resetEnable","false");

		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		//添加过滤规则.
		filterRegistrationBean.addUrlPatterns("/*");
		//添加不需要忽略的格式信息.
		filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*,/mvc/*");

		return filterRegistrationBean;
	}

	@Bean
	public ServletRegistrationBean servletMvcRegistrationBean(){
		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		dispatcherServlet.setContextConfigLocation("classpath:spring/spring-mvc.xml");
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet,"/mvc/*");
		return servletRegistrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(RopCenterApplication.class, args);
	}
}
