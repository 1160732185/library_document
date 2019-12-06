package com.document.ecust.serviceimpl;

import com.document.ecust.service.TypeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
    @Bean
    TypeService getTypeService() { return new TypeServiceImpl(); }
}
