package org.nightvoyager.core.data.roler;

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
            LOGIN,FIND_PASSWD,READ_SYSTEM_STATE,VIEW_PERSONAL_INFO,ROLE_CANDIDATE
            ,VIEW_RELATIVE_EXAMINATION,VIEW_ALL_EXAMINATION,MODIFY_PERSONAL_INFO,
    };
    

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
