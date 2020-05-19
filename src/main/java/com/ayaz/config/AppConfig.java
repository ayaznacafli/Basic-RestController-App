package com.ayaz.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Autowired
    private EnvDetails envDetails;

    @Bean
    @Profile("dev")
    public EnvDetails devEnv() {
        return envDetails;
    }

    @Bean
    @Profile("test")
    public EnvDetails testEnv() {
        return envDetails;
    }

    @Bean
    @Profile("prod")
    public EnvDetails prodEnv() {
        return envDetails;
    }
}