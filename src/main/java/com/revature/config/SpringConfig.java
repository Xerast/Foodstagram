package com.revature.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/** These annotations are replacing what would be in our xml
 *
 *  <mvc:annotation-driven></mvc:annotation-driven>
 *  <context:component-scan base-packages="com.revature"></context:component-scan>
 */
@Configuration
@ComponentScan("com.revature")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer cfg) {
        cfg.enable();
    }
}
