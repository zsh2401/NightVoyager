package org.nightvoyager.core.event;


import org.nightvoyager.core.INVSystem;

public abstract class NVSystemEvent extends Event {
    public INVSystem getNVSystemManager(){
        return nvSystemManager;
    }
    private INVSystem nvSystemManager;
    public NVSystemEvent(INVSystem sm){
        this(sm,sm);
    }
    public NVSystemEvent(Object sender,INVSystem sm){
        super(sender);
        this.nvSystemManager = sm;
        this.nvSystemManager = sm;
    }
}
