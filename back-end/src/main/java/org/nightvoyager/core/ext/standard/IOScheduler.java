package org.nightvoyager.core.ext.standard;

import org.greenrobot.eventbus.Subscribe;
import org.nightvoyager.core.event.ReadStateEvent;
import org.nightvoyager.core.event.SaveStateEvent;
import org.nightvoyager.core.event.TickLoopStartupEvent;
import org.nightvoyager.core.event.TickLoopStoppedEvent;
import org.nightvoyager.core.ext.NVPlugin;
import org.nightvoyager.core.ext.Plugin;
import org.nightvoyager.core.state.TickEvent;
import org.nightvoyager.core.support.NVSystem;

@NVPlugin
public class IOScheduler extends Plugin {

    private static final int SAVE_PER_TICKS = NVSystem.DEFAULT_TICK_PER_SECOND * 30;
    private long tickCounter = 0 ;

    @Subscribe
    public void tickLoopStart(TickLoopStartupEvent e){
        getSystem().getEventBus().postSticky(new ReadStateEvent(getSystem()));
    }

    @Subscribe
    public void tickLoopStopped(TickLoopStoppedEvent e){
        getSystem().getEventBus().post(new SaveStateEvent(getSystem()));
    }

    @Subscribe
    public void onTick(TickEvent e){
        tickCounter = (tickCounter % Long.MAX_VALUE) + 1;
        if(tickCounter % SAVE_PER_TICKS == 0){
            getSystem().getEventBus().post(new ReadStateEvent(getSystem()));
        }
    }

}
