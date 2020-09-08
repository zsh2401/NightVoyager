package org.nightvoyager.core.security;

public class MissingPermissionException extends Exception {
    private final String[] permissions;

    public MissingPermissionException(String... permissions){
        super(getMessage(permissions));
        this.permissions = permissions;
    }
    private static String getMessage(String[] permissions){
        return "Missing permissions: " + String.join(",",permissions);
    }

    public String[] getPermissions() {
        return permissions;
    }
}
