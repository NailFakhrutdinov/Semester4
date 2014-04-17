package com.kpfu.itis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="com.kpfu.itis.controller")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public VelocityConfigurer velocityConfigurer() {
        VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
        velocityConfigurer.setResourceLoaderPath("WEB-INF/velocity/");
        return velocityConfigurer;
    }

    @Bean
    public ViewResolver getViewResolver() {
        VelocityViewResolver velocityViewResolver = new VelocityViewResolver();
        velocityViewResolver.setSuffix(".vm");
        velocityViewResolver.setExposeRequestAttributes(true);
        velocityViewResolver.setExposeSessionAttributes(true);
        velocityViewResolver.setExposeSpringMacroHelpers(true);
        return velocityViewResolver;
    }
}
