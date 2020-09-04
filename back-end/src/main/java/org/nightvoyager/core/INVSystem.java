package org.nightvoyager.core;

import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.nightvoyager.core.data.registries.ITestPaperMasterCopyRegistry;
import org.nightvoyager.core.event.ReadStateEvent;
import org.nightvoyager.core.event.SaveStateEvent;
import org.nightvoyager.core.event.SystemDestroyEvent;
import org.nightvoyager.core.ext.IPluginManager;
import org.nightvoyager.core.state.ICandidatesManager;
import org.nightvoyager.core.state.IExamScheduler;

public interface INVSystem {

    /**
     * Get test paper registry.
     *
     * @return
     */
    @NotNull
    ITestPaperMasterCopyRegistry getTestPaperMCRegistry();

    /**
     * Get plugin manager related to this system.
     *
     * @return
     */
    @NotNull
    IPluginManager getPluginManager();

    /**
     * Get examination scheduler related to this system.
     *
     * @return
     */
    @NotNull
    IExamScheduler getExamScheduler();

    /**
     * Get candidates manager related to this system.
     *
     * @return
     */
    @NotNull
    ICandidatesManager getCandidatesManager();

    /**
     * Get EventBus instance which owned by this system and it's event model.
     *
     * @return
     */
    @NotNull
    EventBus getEventBus();

    /**
     * Default Tick per second setting.
     * The running of Night Voyager System is event driven and based on tick.
     */
    int DEFAULT_TICK_PER_SECOND = 100;

    /**
     * Run the tick loop in current thread.
     * (It's blocking current thread until tick loop is ended)
     */
    void loop() throws NVSystemLoopException;

    /**
     * Destroy this system.
     *
     * @throws IllegalStateException system is running.
     */
    default void destroy() throws IllegalStateException {
        this.getEventBus().post(new SystemDestroyEvent(this));
        this.getEventBus().unregister(this);
    }
}
