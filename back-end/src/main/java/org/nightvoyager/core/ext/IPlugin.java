package org.nightvoyager.core.ext;

/**
 * Standard plugin interface define for the system Night Voyager.
 * Any object implements this interface could be loaded as an plugin.
 */
public interface IPlugin {
    /**
     * Unique id or name for identify one plugin
     * It should returns equals value in ANYTIME
     *
     * @return Unique ID
     */
    default String getId() {
        return "plugin-" + this.getClass().getName();
    }

    /**
     * @return Human readable name.
     */
    default String getName() {
        return getName();
    }

    /**
     * This is plugin life cycle method.
     * After create instance, this method will be called immediately.
     * Throwing any exception will cause this plugin to be abandoned.
     * So, you could throw any exception when this plugin could not be loaded.
     *
     * @param args
     */
    void onLoad(PluginLoadingArgs args) throws Exception;

    /**
     * This is plugin life cycle method.
     * Usually, it is called after this plugin is loaded and enabling.
     * Throwing exception when this plugin can not be enabled,
     * and then the PluginManager will call onDisable method.
     *
     * @param args
     */
    void onEnable(PluginEnablingArgs args) throws Exception;

    /**
     * This is plugin life cycle method.
     * This method will be called by Plugin Manager only at this plugin is running.
     * <p>
     * DO NOT THROWS ANY EXCEPTION IN THERE.
     * ANY PLUGIN MUST SUPPORT DISABLE OPERATION.
     *
     * @param args
     */
    void onDisable(PluginDisablingArgs args);

    /**
     * This is plugin life cycle method.
     * Just like it's name, it will be called when plugin is loading.
     * Please finish all work and save state in this method.
     * DO NOT THROWS ANY EXCEPTION IN THERE.
     *
     * @param args
     */
    void onUnload(PluginUnloadingArgs args);
}
