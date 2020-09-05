package org.nightvoyager.app;

import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.ext.StdPluginLoader;
import org.nightvoyager.core.util.ITickWatcher;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    public static void main(String[] args){
        ConfigurableApplicationContext app = SpringApplication.run(App.class,args);
    }
}
