package com.getRhythm.getRhythm;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/lessons").setViewName("lessons");
		registry.addViewController("/exercises").setViewName("exercises");
		registry.addViewController("/about").setViewName("about");
		registry.addViewController("/account").setViewName("account");
		registry.addViewController("/resources").setViewName("resources");
		registry.addViewController("/createAccount").setViewName("createAccount");
		registry.addViewController("/aboutLoggedOut").setViewName("aboutLoggedOut");
		registry.addViewController("/alreadyExists").setViewName("alreadyExists");



	}

}