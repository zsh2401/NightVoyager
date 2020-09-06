package org.nightvoyager.core.security;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IPermissionComponent {

    @Nullable
    IPermissionComponent getPermissionParent();

    @NotNull
    IPermissionSet getSelfPermissionSet();

    default boolean permissionAllowed(@NotNull String permission) {
        if (getSelfPermissionSet().contains("-" + permission)) {
            return false;
        } else if (getSelfPermissionSet().isAllow(permission)) {
            return true;
        } else if (getPermissionParent() != null) {
            return getPermissionParent().permissionAllowed(permission);
        } else {
            return getSelfPermissionSet().contains("*");
        }
    }
}
