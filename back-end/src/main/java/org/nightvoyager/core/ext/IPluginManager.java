package org.nightvoyager.core.ext;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IPluginManager {
    /**
     * Load plugin to system.
     * @param pluginClass plugin's class code.
     * @return plugin's instance or null if loading progress failed.
     */
    @Nullable
    IPlugin load(Class<? extends IPlugin> pluginClass);

    /**
     * Get loaded plugins.
     * @return
     */
    @NotNull
    IPlugin[] getLoadedPlugins();


    /**
     * Unload the plugin from this system.
     * @param plugin
     * @throws IllegalArgumentException plugin not exist in this system.
     */
    void unload(IPlugin plugin) throws IllegalArgumentException;
}
