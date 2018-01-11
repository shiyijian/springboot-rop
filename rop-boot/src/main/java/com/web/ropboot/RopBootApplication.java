package com.web.ropboot;

import com.rop.RopServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ImportResource("spring/applicationContext.xml")
@SpringBootApplication
public class RopBootApplication {

	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		return new ServletRegistrationBean(new RopServlet(),"/router");
	}

	public static void main(String[] args) {
		SpringApplication.run(RopBootApplication.class, args);
	}
}
