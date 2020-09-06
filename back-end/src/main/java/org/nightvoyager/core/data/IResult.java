package org.nightvoyager.core.data;

import org.nightvoyager.core.data.roler.IPersonInfo;

public interface IResult {
    String getId();
    ITestPaperMasterCopy getTestPaper();
    IPersonInfo getOwners();
    IPersonInfo getCheckers();
    int getScore();
}
