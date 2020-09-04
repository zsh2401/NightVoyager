package org.nightvoyager.core.ext;

import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.event.CancelableNVSystemEvent;
import org.nightvoyager.core.event.ICancelable;

public class PluginLoadingEvent extends CancelableNVSystemEvent {
    private final Class<?> target;
    private final IPluginManager pluginManager;
    public PluginLoadingEvent(IPluginManager pm, INVSystem system, Class<?> target) {
        super(pm,system);
        this.target = target;
        this.pluginManager = pm;
        this.setCancelMode(CancelMode.ONE_VOTE_TO_CANCEL);
    }

    public Class<?> getTarget() {
        return target;
    }
}
