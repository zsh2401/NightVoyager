package org.nightvoyager.core.ext;

import java.util.Map;
import java.util.Properties;

public interface IPlugin {
    default String getId(){
        return "plugin-" + this.getClass().getName();
    }
    void onLoad(PluginLoadingArgs args);
    void onEnable(PluginEnablingArgs args);
    void onDisable(PluginDisablingArgs args);
    void onUnload(PluginUnloadingArgs args);
}
