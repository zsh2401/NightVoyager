package org.nightvoyager.core.event;

import org.nightvoyager.core.INVSystem;

public class SaveStateEvent extends NVSystemEvent{
    public SaveStateEvent(INVSystem sm) {
        super(sm);
    }
}
