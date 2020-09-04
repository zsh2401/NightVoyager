package org.nightvoyager.core.event;

import org.nightvoyager.core.INVSystem;

/**
 * Current nv system's tick loop is started.
 */
public class TickLoopStartupEvent extends NVSystemEvent{
    public TickLoopStartupEvent(INVSystem sm) {
        super(sm);
    }
}
