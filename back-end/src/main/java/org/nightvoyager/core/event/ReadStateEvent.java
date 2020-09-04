package org.nightvoyager.core.event;

import org.nightvoyager.core.INVSystem;

public class ReadStateEvent extends NVSystemEvent {
    public ReadStateEvent(INVSystem sm) {
        super(sm);
    }
}
