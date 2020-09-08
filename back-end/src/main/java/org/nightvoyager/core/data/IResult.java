package org.nightvoyager.core.data;

public interface IResult {
    String getId();
    ITestPaperMasterCopy getTestPaper();
    IPersonInfo getOwners();
    IPersonInfo getCheckers();
    int getScore();
}
