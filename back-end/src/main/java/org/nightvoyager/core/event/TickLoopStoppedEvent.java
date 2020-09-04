package org.nightvoyager.core.event;

import org.nightvoyager.core.INVSystem;

public class TickLoopStoppedEvent extends NVSystemEvent {
    public TickLoopStoppedEvent(INVSystem sm) {
        super(sm);
    }
}
