package com.formacionbdi.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@RibbonClient(name = "servicio-productos") se implementa cuando no se usa Eureka.
@EnableEurekaClient //Solo con la dependencia de client agregada, no es necesaria esta notación
@EnableFeignClients
//@EnableCircuitBreaker //Para tolerancia a fallo. Se necesita la dependencia Hystrix
@SpringBootApplication
public class SpringbootServicioItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioItemApplication.class, args);
    }

}
