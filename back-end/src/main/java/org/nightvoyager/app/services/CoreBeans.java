package org.nightvoyager.app.services;

import org.greenrobot.eventbus.EventBus;
import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.NVSystemLoopException;
import org.nightvoyager.core.data.IDataAccessor;
import org.nightvoyager.core.state.ICandidatesManager;
import org.nightvoyager.core.support.NVSystem;
import org.nightvoyager.core.util.ITickWatcher;
import org.nightvoyager.core.util.TickWatcher;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreBeans {

    @Bean(destroyMethod = "destroy")
    public INVSystem nvSystem(IDataAccessor dataAccessor) {
        return new NVSystem(){
            @Override
            protected IDataAccessor createDataAccessor() {
                this.getEventBus().register(dataAccessor);
                return dataAccessor;
            }

            @Override
            public void destroy() throws IllegalStateException {
                this.getEventBus().unregister(dataAccessor);
            }
        };
    }

    @Bean(destroyMethod = "stop",initMethod = "start")
    public ITickWatcher tickWatcher(INVSystem system) {
        return new TickWatcher(system);
    }

    @Bean(destroyMethod = "destroy")
    public IDataAccessor dataAccessor(){
        return new DAO();
    }
}
