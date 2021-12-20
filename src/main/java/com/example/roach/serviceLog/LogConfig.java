package com.example.roach.serviceLog;

import com.example.roach.option.Option;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class LogConfig {
    @Bean
    CommandLineRunner commandLineRunner(LogRepository repository) {
        return args -> {
            ServiceLog log1 = new ServiceLog(
                    1L,
                    Arrays.asList(new Option("tire change", 12.5),new Option("paint", 20.0) ),
                    LocalDate.of(2020,6,25),
                    LocalDate.now()
            );

//            ServiceLog log2 = new ServiceLog(
//                    2L,
//                    Arrays.asList(new Option("paint", 20.0), new Option("tire change", 12.5) ),
//                    LocalDate.of(2021,2,5),
//                    LocalDate.now()
//            );

            repository.saveAll(Arrays.asList(log1));
        };
    }
}
