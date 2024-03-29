package com.springboot.formacionbdi.springbootzuulserverspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient //No es necesario expresarlo, solo con la dependecnia agregada bastaría.
@EnableZuulProxy
@SpringBootApplication
public class SpringbootZuulServerSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootZuulServerSpringApplication.class, args);
    }

}
