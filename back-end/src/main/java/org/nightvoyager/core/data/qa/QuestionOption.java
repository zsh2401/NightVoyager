package org.nightvoyager.core.data.qa;

public class QuestionOption {
    public static final long DEFAULT = 0b01011;
    public static final long SUPPORT_REWORK = 1 << 0;
    public static final long SUPPORT_REVIEW = 1 << 1;
    public static final long SUPPORT_VIEW_ANSWER = 1 << 2;
    public static final long SUPPORT_GIVE_UP = 1 << 3;
    public static final long MUST_FINISH_BEFORE = 1 << 4;
}