package org.nightvoyager.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootApplication
public class App {
    public static void main(String[] args){
        ConfigurableApplicationContext app = SpringApplication.run(App.class,args);
    }
}
