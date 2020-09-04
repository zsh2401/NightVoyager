package org.nightvoyager.core.event;

import org.nightvoyager.core.INVSystem;

public class SystemDestroyEvent extends NVSystemEvent {
    public SystemDestroyEvent(INVSystem sm) {
        super(sm);
    }
}
