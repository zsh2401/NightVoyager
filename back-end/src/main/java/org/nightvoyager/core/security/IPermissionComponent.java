package org.nightvoyager.core.security;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IPermissionComponent {

    @Nullable
    default IPermissionComponent getPermissionParent() {
        return null;
    }

    @NotNull
    IPermissionSet getSelfPermissionSet();

    default void must(String... permissions) throws MissingPermissionException {
        PermissionHelper.must(this, permissions);
    }

    default boolean permissionAllowed(@NotNull String permission) {
        final IPermissionComponent parent = getPermissionParent();
        if (getSelfPermissionSet().isAllow(permission)) {
            return true;
        } else if (parent != null) {
            return parent.permissionAllowed(permission);
        } else {
            return false;
        }
    }
}
