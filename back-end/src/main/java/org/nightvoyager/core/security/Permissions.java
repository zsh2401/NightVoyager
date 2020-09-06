package org.nightvoyager.core.security;

import java.util.*;

public class Permissions {

    public static final String ROLE_SUPER_USER = "nv.system.superuser";
    public static final String ROLE_ADMINISTRATOR = "nv.system.administrator";
    public static final String ROLE_TEACHER = "nv.system.teacher";
    public static final String ROLE_CANDIDATE = "nv.system.default";

    public static final String READ_SYSTEM_STATE = "nv.system.read_state";
    public static final String LOGIN = "nv.auth.login";
    public static final String FIND_PASSWD = "nv.auth.find_passwd";
    public static final String VIEW_RELATIVE_EXAMINATION = "nv.exam.view.relative";
    public static final String VIEW_ALL_EXAMINATION = "nv.exam.view.*";
    public static final String MODIFY_PERSONAL_INFO = "nv.account.modify";
    public static final String VIEW_PERSONAL_INFO = "nv.account.view";
    public static final String VIEW_OTHER_PERSON_INFO = "nv.account.view_other";

    public static final String[] DEFAULT_CANDIDATE_PERMISSIONS = new String[]{
            LOGIN, FIND_PASSWD, READ_SYSTEM_STATE, VIEW_PERSONAL_INFO, ROLE_CANDIDATE
            , VIEW_RELATIVE_EXAMINATION, VIEW_ALL_EXAMINATION, MODIFY_PERSONAL_INFO,
    };

    public static String toString(String[] permissions) {
        return String.join(",", permissions);
    }

    public static boolean includes(String[] source, String[] toBeIncluded) {
        HashSet<String> set = new HashSet<>(Arrays.asList(source));
        long oldSize = set.size();
        set.addAll(Arrays.asList(toBeIncluded));
        return oldSize == set.size();
    }

    public static String[] combineAllowed(String[]... permissionCollections) {
        HashSet<String> builder = getBuilder();
        allAdd(builder, permissionCollections);
        keepAllowed(builder);
        return toResult(builder);
    }

    private static final HashMap<String[][],String[]> cache = new HashMap<>();

    private String[] getCache(String[][] permissionCollections){
        cache.get(permissionCollections);
        return null;
    }

    public static String[] combine(String[]... permissionCollections) {
        HashSet<String> builder = getBuilder();
        allAdd(builder, permissionCollections);
        return toResult(builder);
    }

    private static void keepAllowed(HashSet<String> builder) {
        builder.removeIf(it -> it.startsWith("-"));
    }

    private static void allAdd(HashSet<String> builder, String[][] permissionCollections) {
        for (String[] permissions :
                permissionCollections) {
            builder.addAll(Arrays.asList(permissions));
        }
    }

    private static HashSet<String> getBuilder() {
        return new HashSet<>();
    }

    private static String[] toResult(HashSet<String> builder) {
        final String[] convert = new String[0];
        return builder.toArray(new String[0]);
    }


//    public static long ADMINISTRATOR_PERMISSION
//    public static boolean hasPermission(long permission, long include){
//        return (permission & include) == include;
//    }
//    public static long addPermission(long permission,long add){
//        return permission + add;
//    }
//    public static long removePermission(long permission,long remove){
//        /**
//         * 0b1111
//         * 0b0101
//         * ----
//         * 0b1010
//         */
//        return permission - remove;
//    }
}
