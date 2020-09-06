package org.nightvoyager.core.support;

import org.greenrobot.eventbus.Subscribe;
import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.event.SystemDestroyEvent;
import org.nightvoyager.core.ext.*;

import java.util.ArrayList;
import java.util.List;

public class PluginManager extends NVSystemObject implements IPluginManager {

    private final List<IPlugin> plugins = new ArrayList<>();

    public PluginManager(INVSystem system) {
        super(system);
    }

    @Override
    public IPlugin load(Class<? extends IPlugin> pluginClass) {
        try {

            //Raise event.
            PluginLoadingEvent e = new PluginLoadingEvent(this, getNVSystem(), pluginClass);
            getNVSystem().getEventBus().post(e);
            if (e.isCancel()) {
                return null;
            }

            //Create plugin
            IPlugin plugin = createPluginInstance(pluginClass);

            plugin.onLoad(new PluginLoadingArgs(getNVSystem()));
            plugin.onEnable(new PluginEnablingArgs());

            synchronized (plugins) {
                plugins.add(plugin);
            }

            return plugin;
        } catch (Exception e) {
            getLogger().error("Could not load plugin: " + pluginClass.getName(), e);
        }
        return null;
    }


    protected IPlugin createPluginInstance(Class<? extends IPlugin> pluginClass) throws IllegalAccessException, InstantiationException {
        return pluginClass.newInstance();
    }


    protected void enablePlugin(IPlugin plugin) {

    }

    protected void disablePlugin(IPlugin plugin) {
        plugin.onDisable(new PluginDisablingArgs());
    }

    @Override
    public IPlugin[] getLoadedPlugins() {
        final IPlugin[] covert = new IPlugin[0];
        return plugins.toArray(covert);
    }


    @Subscribe
    public void onDestroy(SystemDestroyEvent e) {
        for (IPlugin plugin :
                plugins) {
            plugin.onDisable(new PluginDisablingArgs());
            plugin.onUnload(new PluginUnloadingArgs());
        }
        plugins.clear();
    }

    @Override
    public synchronized void unload(IPlugin plugin) {
        if (plugin == null) return;
        try {
            plugin.onDisable(new PluginDisablingArgs());
            plugin.onUnload(new PluginUnloadingArgs());
        } catch (Exception e) {
            getLogger().warn(
                    "Shame on " +
                            plugin.getClass().getName() +
                            ": It's throws exception when unloading progress!", e);
        }
        synchronized (plugins) {
            plugins.remove(plugin);
        }
    }
}
