package org.nightvoyager.core.ext;

import java.util.Map;

public interface IPlugin {
    Map<String,String> getMetadata();
    void onLoad(PluginLoadingArgs args);
    void onEnable(PluginEnablingArgs args);
    void onDisable(PluginDisablingArgs args);
    void onUnload(PluginUnloadingArgs args);
}
