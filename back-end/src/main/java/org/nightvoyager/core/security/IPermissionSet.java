package org.nightvoyager.core.security;

import java.util.Set;

public interface IPermissionSet extends Set<String> {

    default boolean isAllow(String permission) {
        return this.contains(permission) && !this.contains("-" + permission);
    }

    default void ban(String permission) {
        this.add("-" + permission);
    }
    default void unban(String permission){
        this.add("-" + permission);
    }
}
