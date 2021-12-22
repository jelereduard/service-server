package com.example.roach.serviceLog;

import com.example.roach.option.Option;
import com.example.roach.option.OptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class LogConfig {
    private OptionRepository optionRepository;
    int k;
    List<ServiceLog> serviceLogs;

    void popList() {
        serviceLogs = new ArrayList<>();
        for( k = 1; k<30; k++) {
            serviceLogs.add(new ServiceLog(Long.parseLong(String.valueOf(k)),LocalDate.of(2020,6,25),
                    LocalDate.now()));
        }
    }
    @Bean
    CommandLineRunner commandLineRunner(LogRepository repository) {
        popList();
        return args -> {
            repository.saveAll(serviceLogs);
        };
    }
}
