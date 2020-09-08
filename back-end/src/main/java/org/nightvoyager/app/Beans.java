package org.nightvoyager.app;

import org.greenrobot.eventbus.EventBus;
import org.nightvoyager.app.service.db.DAO;
import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.data.IDataAccessor;
import org.nightvoyager.core.support.NVSystem;
import org.nightvoyager.core.util.ITickWatcher;
import org.nightvoyager.core.util.TickWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Beans {

    @Bean(destroyMethod = "destroy")
    public INVSystem nvSystem(IDataAccessor dataAccessor,EventBus eventBus) {
        return new NVSystem(){
            @Override
            protected IDataAccessor createDataAccessor() {
                return dataAccessor;
            }

            @Override
            protected EventBus createEventBus() {
                return eventBus;
            }

            @Override
            public void destroy() throws IllegalStateException {
                this.getEventBus().unregister(dataAccessor);
            }
        };
    }

    @Bean
    public EventBus eventBus(){
        return EventBus.getDefault();
    }

    @Bean(destroyMethod = "stop",initMethod = "start")
    public ITickWatcher tickWatcher(INVSystem system) {
        return new TickWatcher(system);
    }

    @Bean(initMethod = "initialize",destroyMethod = "destroy")
    public IDataAccessor dataAccessor(){
        return new DAO();
    }

    @Bean
    @Scope("prototype")
    public Logger produceLogger(InjectionPoint injectionPoint) {
        Class<?> classOnWired = injectionPoint.getMember().getDeclaringClass();
        return LoggerFactory.getLogger(classOnWired);
    }
}
