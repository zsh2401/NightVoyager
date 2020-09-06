package org.nightvoyager.core.util;

import org.greenrobot.eventbus.Subscribe;
import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.NVSystemLoopException;
import org.nightvoyager.core.state.TickEvent;

public final class TickWatcher implements ITickWatcher {
    @org.jetbrains.annotations.NotNull
    private final INVSystem system;

    public TickWatcher(INVSystem system) {
        this.system = system;
        system.getEventBus().register(this);
    }

    private boolean isRunning = false;
    private boolean requestStop = false;
    private Thread loopThread;

    public boolean isRunning() {
        return isRunning;
    }

    public synchronized void stop() throws IllegalStateException {
        if (!isRunning()) {
            throw new IllegalStateException();
        }
        requestStop = true;
    }

    public synchronized void start() throws IllegalStateException {
        if (loopThread != null || isRunning == true) {
            throw new IllegalStateException();
        }
        loopThread = new Thread(null, () -> {
            isRunning = true;
            try {
                system.loop();
            } catch (NVSystemLoopException e) {
                e.printStackTrace();
            } finally {
                isRunning = false;
                requestStop = false;
                loopThread = null;
            }
        }, "TickWatcherThread@" + this.system.hashCode());
        loopThread.start();
    }

    @Subscribe
    public void onTick(TickEvent e) {
        if (requestStop) {
            e.setContinuable(false);
        }
    }
}
