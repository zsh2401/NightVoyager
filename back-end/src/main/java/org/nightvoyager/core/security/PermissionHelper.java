package org.nightvoyager.core.security;

import java.util.Arrays;
import java.util.HashSet;

public class PermissionHelper {
    public static String[] getParentNodes(String permission){
        String[] splited = permission.substring().split(".");
    }
    public static HashSet<String> combine(HashSet<String>... permissionSets){
        HashSet<String> builder = new HashSet<>();
        Arrays.stream(permissionSets).map(it->{
            builder.addAll(it);
            return true;
        });
        return builder;
    }

    public static void addBan(HashSet<String> set,String permission){
        set.add(permission);
    }
    public static void hasBanned()
}
