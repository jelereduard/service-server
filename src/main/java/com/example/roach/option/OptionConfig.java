package com.example.roach.option;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OptionConfig {

    @Bean
    CommandLineRunner optionConfigInit(OptionRepository repository) {
        return args -> {
            Option option1 = new Option("oil change", 10.0);
            Option option2 = new Option("tire change", 12.5);
            Option option3 = new Option("paint", 20.0);
            Option option4 = new Option("tire calibration", 25.0);
            Option option5 = new Option("battery change + battery", 29.99);

            repository.saveAll(Arrays.asList(option1, option2, option3, option4, option5));
        };
    }
}