package org.nightvoyager.core.ext.standard;

import org.greenrobot.eventbus.Subscribe;
import org.nightvoyager.core.event.SaveStateEvent;
import org.nightvoyager.core.ext.NVPlugin;
import org.nightvoyager.core.ext.Plugin;
import org.nightvoyager.core.state.TickEvent;
import org.nightvoyager.core.support.NVSystem;

@NVPlugin
public class SaveStateEventScheduler extends Plugin {

    private static final int SAVE_PER_TICKS = NVSystem.DEFAULT_TICK_PER_SECOND * 30;
    private int tickCounter = 0 ;

    @Subscribe
    public void onTick(TickEvent e){
        tickCounter = ++tickCounter % SAVE_PER_TICKS;
        if(tickCounter == 0){
            getSystem().getEventBus().post(new SaveStateEvent(getSystem()));
        }
    }
}
