package org.nightvoyager.core.data;

import org.nightvoyager.core.data.roler.IPersonInfo;

/**
 * Readonly Examination info.
 * Should be created by some type of builder with data stored in database or file.
 */
public interface IExaminationInfo extends IUnique {

    IPersonInfo[] getRelativeCandidates();

    long getStartTime();

    long setStartTime(long startTime);

    long getTimeLimit();

    long setTimeLimit(long timeLimit);

    String getDescription();
    void setDescription(String description);

    String getNotice();
    void setNotice(String notice);

    ITestPaperMasterCopy[] getTestPapers();
}
