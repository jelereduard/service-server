package com.example.roach.car;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class CarConfig {

    @Bean(name = "datasource1")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "datasource1")
    @ConfigurationProperties(prefix="spring.secondDatasource")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Bean(name="tm1")
//    @Autowired
//    @Primary
//    DataSourceTransactionManager tm1(@Qualifier("datasource1") DataSource datasource) {
//        DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
//        return txm;
//    }
//
//    @Bean(name="tm2")
//    @Autowired
//    DataSourceTransactionManager tm2(@Qualifier ("datasource2") DataSource datasource) {
//        DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
//        return txm;
//    }
    
//    @Bean
//    CommandLineRunner carConfigInit(CarRepository repository) {
//        return args -> {
//            Car car1 = new Car(
//                    "Audi",
//                    "A6",
//                    "Red",
//                    2014,
//                    "CJ06QAZ"
//            );
//            Car car2 = new Car(
//                    "BMW",
//                    "e46",
//                    "Blue",
//                    1998,
//                    "CJ46BMW"
//            );
//            repository.saveAll(Arrays.asList(car1, car2));
//        };
//    }
}
