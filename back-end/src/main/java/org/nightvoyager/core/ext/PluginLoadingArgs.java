package org.nightvoyager.core.ext;

import org.nightvoyager.core.INVSystem;

public class PluginLoadingArgs {
    private final INVSystem nvSystem;
    public PluginLoadingArgs(INVSystem nvSystem) {
        this.nvSystem = nvSystem;
    }
    public INVSystem getNvSystem(){
        return this.nvSystem;
    }
}
