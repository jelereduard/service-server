package com.example.roach.serviceLog;

import com.example.roach.option.Option;
import com.example.roach.option.OptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class LogConfig {
    private OptionRepository optionRepository;
    @Bean
    CommandLineRunner commandLineRunner(LogRepository repository) {
        return args -> {
            ServiceLog log1 = new ServiceLog(
                    1L,
                    LocalDate.of(2020,6,25),
                    LocalDate.now()
            );
            repository.saveAll(Arrays.asList(log1));
        };
    }
}
