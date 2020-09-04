package org.nightvoyager.core.state;

import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.event.NVSystemEvent;

public class TickEvent extends NVSystemEvent {

    public TickEvent(INVSystem sm) {
        super(sm);
    }

    private boolean couldContinue = true;

    public boolean couldContinue() {
        return couldContinue;
    }

    public void setContinuable(boolean v) {
        couldContinue = v;
    }
}
