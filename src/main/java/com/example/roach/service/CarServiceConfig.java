package com.example.roach.service;

import com.example.carService.car.Car;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class CarServiceConfig {

    @Bean
    CommandLineRunner serviceConfigInit(CarServiceRepository carServiceRepository) {
        return args -> {
            CarService carService1 = new CarService(
                    "Manastur",
                    12,
                    Arrays.asList(
                            new Car(
                                    "Audi",
                                    "A6",
                                    "Red",
                                    2014,
                                    "CJ06QAZ"
                            ),
                            new Car(
                                    "Dacia",
                                    "Logan",
                                    "Yellow",
                                    2007,
                                    "CJ10DAC"
                            )
                    )
            );
            CarService carService2 = new CarService(
                    "Marasti",
                    12,
                    Arrays.asList(
                            new Car(
                                    "BMW",
                                    "e46",
                                    "Black",
                                    1998,
                                    "CJ46BMW"
                            ),
                            new Car(
                                    "Dacia",
                                    "Sandero",
                                    "White",
                                    2012,
                                    "CJ12SND"
                            ),
                            new Car(
                                    "Opel",
                                    "Astra H",
                                    "Gray",
                                    2004,
                                    "BN99QWE"
                            )
                    )
            );
            CarService carService3 = new CarService(
                    "Grigorescu",
                    12,
                    Arrays.asList(
                            new Car(
                                    "BMW",
                                    "e46",
                                    "Black",
                                    1998,
                                    "CJ46BMW"
                            ),
                            new Car(
                                    "Dacia",
                                    "Sandero",
                                    "White",
                                    2012,
                                    "CJ12SND"
                            ),
                            new Car(
                                    "Opel",
                                    "Astra H",
                                    "Gray",
                                    2004,
                                    "BN99QWE"
                            )
                    )
            );
            CarService carService4 = new CarService(
                    "Gheorgheni",
                    12,
                    Arrays.asList(
                            new Car(
                                    "BMW",
                                    "e46",
                                    "Black",
                                    1998,
                                    "CJ46BMW"
                            ),
                            new Car(
                                    "Dacia",
                                    "Sandero",
                                    "White",
                                    2012,
                                    "CJ12SND"
                            ),
                            new Car(
                                    "Opel",
                                    "Astra H",
                                    "Gray",
                                    2004,
                                    "BN99QWE"
                            )
                    )
            );
            CarService carService5 = new CarService(
                    "Europa",
                    12,
                    Arrays.asList(
                            new Car(
                                    "BMW",
                                    "e46",
                                    "Black",
                                    1998,
                                    "CJ46BMW"
                            ),
                            new Car(
                                    "Dacia",
                                    "Sandero",
                                    "White",
                                    2012,
                                    "CJ12SND"
                            ),
                            new Car(
                                    "Opel",
                                    "Astra H",
                                    "Gray",
                                    2004,
                                    "BN99QWE"
                            )
                    )
            );
            CarService carService6 = new CarService(
                    "Baciu",
                    12,
                    Arrays.asList(
                            new Car(
                                    "BMW",
                                    "e46",
                                    "Black",
                                    1998,
                                    "CJ46BMW"
                            ),
                            new Car(
                                    "Dacia",
                                    "Sandero",
                                    "White",
                                    2012,
                                    "CJ12SND"
                            ),
                            new Car(
                                    "Opel",
                                    "Astra H",
                                    "Gray",
                                    2004,
                                    "BN99QWE"
                            )
                    )
            );
            CarService carService7 = new CarService(
                    "Floresti",
                    12,
                    Arrays.asList(
                            new Car(
                                    "BMW",
                                    "e46",
                                    "Black",
                                    1998,
                                    "CJ46BMW"
                            ),
                            new Car(
                                    "Dacia",
                                    "Sandero",
                                    "White",
                                    2012,
                                    "CJ12SND"
                            ),
                            new Car(
                                    "Opel",
                                    "Astra H",
                                    "Gray",
                                    2004,
                                    "BN99QWE"
                            )
                    )
            );
            CarService carService8 = new CarService(
                    "Centru",
                    12,
                    Arrays.asList(
                            new Car(
                                    "BMW",
                                    "e46",
                                    "Black",
                                    1998,
                                    "CJ46BMW"
                            ),
                            new Car(
                                    "Dacia",
                                    "Sandero",
                                    "White",
                                    2012,
                                    "CJ12SND"
                            ),
                            new Car(
                                    "Opel",
                                    "Astra H",
                                    "Gray",
                                    2004,
                                    "BN99QWE"
                            ),
                            new Car(
                                    "Fiat",
                                    "Punto",
                                    "Blue",
                                    2002,
                                    "CJ01FIA"
                            ),
                            new Car(
                                    "Opel",
                                    "Astra H",
                                    "brown",
                                    2004,
                                    "BN99AWE"
                            ),
                            new Car(
                                    "Opel",
                                    "Astra",
                                    "coral",
                                    2004,
                                    "IF55QQQ"
                            ),
                            new Car(
                                    "Opel",
                                    "Cadet",
                                    "Gray",
                                    2000,
                                    "BN99QWE"
                            ),
                            new Car(
                                    "Opel",
                                    "Astra H",
                                    "cornflowerblue",
                                    2004,
                                    "BN91QWE"
                            ),
                            new Car(
                                    "Opel",
                                    "Astra ",
                                    "khaki",
                                    2004,
                                    "CJ29QWE"
                            )
                    )
            );
            carServiceRepository.saveAll(Arrays.asList(carService1, carService2, carService3, carService4, carService5, carService6, carService7, carService8));
        };
    }
}
