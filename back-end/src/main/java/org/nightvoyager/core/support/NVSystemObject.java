package org.nightvoyager.core.support;

import org.greenrobot.eventbus.Subscribe;
import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.event.SystemDestroyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public abstract class NVSystemObject {

    private final INVSystem system;
    private final Logger logger;

    public NVSystemObject(INVSystem system) {
        this.system = system;
        logger = LoggerFactory.getLogger(this.getClass());
        system.getEventBus().register(this);
    }

    protected final INVSystem getNVSystem() {
        return system;
    }

    protected Logger getLogger() {
        return logger;
    }

    @Subscribe
    public final void onDestroyHandler(SystemDestroyEvent e){
        onDestroy(e);
        system.getEventBus().unregister(this);
    }

    protected void onDestroy(SystemDestroyEvent e){
    }
}
