package org.nightvoyager.app.services;

import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.state.ICandidatesManager;
import org.nightvoyager.core.support.NVSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceFactory {
    @Bean
    public INVSystem nvSystem(ICandidatesManager candidatesManager){
        INVSystem system =  new NVSystem(candidatesManager);
        new Thread(()->{
            Thread.currentThread().setName("NVSystem main thread");
            system.loop();
        }).start();
        return system;
    }
    @Bean
    public ICandidatesManager candidatesManager(){
        return null;
    }
}
