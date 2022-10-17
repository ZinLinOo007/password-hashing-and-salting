package com.example.springsecuritymaster.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;

@Configuration
public class SecurityContentConfiguration {

    @Value("${spring.security.context.strategy}")
    private String securityContextStrategy;

    @PostConstruct
    public void init(){

        SecurityContextHolder.setStrategyName(securityContextStrategy);

    }
}
