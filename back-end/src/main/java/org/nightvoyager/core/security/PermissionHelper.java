package org.nightvoyager.core.security;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PermissionHelper {
    /**
     * Prevent
     */
    private PermissionHelper() {
    }

    /**
     * Check if the specified permission set is allowed the target permission.
     * <p>
     * ===============================================
     * VALUE TABLE
     * Set includes     to check if allowed     result
     * ===============================================
     * nv.read_state    nv.read_state           TRUE
     * -nv.read_state   nv.read_state           FALSE
     * NONE             nv.read_state           FALSE
     * nv.*             nv.read_state           TRUE
     * nv.some.*        nv.some.write           TRUE
     * nv.some.*        nv.some.*               TRUE
     * nv               nv.read_state           FALSE
     * nv.system.*      nv.read_state           FALSE
     * *                any.permissions         TRUE
     * -*               any.permissions         FALSE
     *
     * @param set
     * @param permission
     * @return
     */
    public static boolean isAllowed(IPermissionSet set, String permission) {
        final boolean NOT_ALLOWED = false;
        final boolean ALLOWED = true;
        final String BANNED_PREFIX = "-";
        final String ALL_MARK = "*";
        final String SUPER_USER_S_PERMISSION = ALL_MARK;
        if (permission.startsWith(BANNED_PREFIX)) {
            throw new IllegalArgumentException("Should not starts with '-'");
        }
        if (set.contains(SUPER_USER_S_PERMISSION)) {
            return true;
        }
        if (isBanned(set, permission)) {
            return NOT_ALLOWED;
        }

        return allAllowedInParent(set, permission) ? ALLOWED : set.contains(permission);
    }

    private static boolean allAllowedInParent(IPermissionSet set, String permission) {
        final String[] parentPermissions = getParents(permission);
        for (String parentPermission :
                parentPermissions) {
            final String all = parentPermission + ".*";
            if (set.contains(all)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get the permission's parents.
     * <p>
     * Example:
     * nv.system                nv
     * nv.system.read.all       nv,nv.system,nv.system.read
     *
     * @param permission
     * @return
     */
    public static String[] getParents(String permission) {
        final String[] nodes = toNodes(permission);
        final String[] result = new String[nodes.length - 1];
        for (int i = 0; i < result.length; i++) {
            final String[] buffer = new String[i + 1];
            for (int j = 0; j < i + 1; j++) {
                buffer[j] = nodes[j];
            }
            result[i] = String.join(".", buffer);
        }
        return result;
    }

    private static String[] toNodes(String permission) {
        return permission.split("\\.");
    }

    public static boolean isBanned(IPermissionSet set, String permission) {
        if (permission.startsWith("-")) {
            throw new IllegalArgumentException("Should not starts with '-'");
        }
        return set.contains("-" + permission);
    }

    /**
     * Throws {@link MissingPermissionException}
     * if required permission(s) is not allowed
     * in specified {@link IPermissionComponent}
     *
     * @param permissionComponent
     * @param permissions
     * @throws MissingPermissionException
     */
    public static void must(IPermissionComponent permissionComponent, String... permissions) throws MissingPermissionException {
        List<String> missing = new LinkedList<>();
        for (String permission :
                permissions) {
            if (!permissionComponent.permissionAllowed(permission)) {
                missing.add(permission);
            }
        }
        if (missing.size() > 0) {
            throw new MissingPermissionException(missing.toArray(new String[0]));
        }
    }
}
