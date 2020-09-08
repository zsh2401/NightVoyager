package org.nightvoyager.core.security;

import java.util.HashSet;
import java.util.Set;

public interface IPermissionSet extends Set<String> {

    public class HashPermissionSet extends HashSet<String> implements IPermissionSet{}

    default boolean isAllow(String permission) {
        return PermissionHelper.isAllowed(this, permission);
    }

    default void ban(String permission) {
        if (!isBanned(permission)) {
            this.add("-" + permission);
        }
    }

    default boolean isBanned(String permission) {
        return PermissionHelper.isBanned(this, permission);
    }

    default void unban(String permission) {
        if (isBanned(permission)) {
            this.remove("-" + permission);
        }
    }
}
