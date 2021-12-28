package com.abdulhalim.config;

import com.abdulhalim.util.RandonUtilsId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UniqueKeyConfiguration {

    @Bean
    public RandonUtilsId uuid(){

        return new RandonUtilsId();
    }
}
