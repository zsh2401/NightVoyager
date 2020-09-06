package org.nightvoyager.core.data;

public interface ITestPaperMasterCopy extends IUnique {

    IQuestion[] getQuestions();

    String getTitle();
    void setTitle(String newTitle);

    String getPublisherName();
    void setPublisherName(String publisherName);

    long UNLIMITED = -1;

    long getTimeLimitation();
    void setTimeLimitation(long newTimeLimitation);

    String getDescription();
    void setDescription(String desc);
}
