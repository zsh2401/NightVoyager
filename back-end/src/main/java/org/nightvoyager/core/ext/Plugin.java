package org.nightvoyager.core.ext;

import org.nightvoyager.core.INVSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Plugin implements IPlugin {

    private INVSystem system;
    private boolean enabled = false;
    private final Logger logger;

    public Plugin(){
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public void onLoad(PluginLoadingArgs args) {
        system = args.getNvSystem();
    }

    @Override
    public void onEnable(PluginEnablingArgs args) {
        setEnabled(true);
        system.getEventBus().register(this);
    }

    @Override
    public void onDisable(PluginDisablingArgs args) {
        setEnabled(false);
        system.getEventBus().unregister(this);
    }

    @Override
    public void onUnload(PluginUnloadingArgs args) {

    }

    public INVSystem getSystem() {
        return system;
    }

    public boolean isEnabled() {
        return enabled;
    }

    private void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Logger getLogger() {
        return logger;
    }
}
