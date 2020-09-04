package org.nightvoyager.core.state;

import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.event.NVSystemEvent;

public class PreTickEvent extends NVSystemEvent {
    public PreTickEvent(INVSystem sm) {
        super(sm);
    }

    private boolean v = false;
    public boolean isNextTickCancelled(){
        return v;
    }
    public void setCancelNextTick(boolean v){
        this.v = v;
    }
}
