package com.github.football.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.github.football.util.api")
@Configuration
public class FeignConfig {
}
