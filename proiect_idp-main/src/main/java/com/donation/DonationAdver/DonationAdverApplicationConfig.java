package com.donation.DonationAdver;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DonationAdverApplicationConfig {

    ModelMapper mapper;

    @Bean
    public ModelMapper mapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}
