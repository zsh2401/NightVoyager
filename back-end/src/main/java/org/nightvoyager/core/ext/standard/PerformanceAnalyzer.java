package org.nightvoyager.core.ext.standard;

import org.greenrobot.eventbus.Subscribe;
import org.nightvoyager.core.event.TickLoopStartupEvent;
import org.nightvoyager.core.ext.Plugin;
import org.nightvoyager.core.state.TickEvent;

public class PerformanceAnalyzer extends Plugin {

    long startTime,tickTimes;


    @Subscribe
    public void onSystemStartup(TickLoopStartupEvent e){
        startTime = System.currentTimeMillis();
    }

    @Subscribe
    public void onTick(TickEvent e){
        tickTimes++;
    }
}
