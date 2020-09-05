package org.nightvoyager.core.data;

import org.nightvoyager.core.data.qa.ITestPaperInfo;
import org.nightvoyager.core.data.roler.IPersonInfo;

import java.util.List;

public interface IResult {
    String getId();
    ITestPaperInfo getTestPaper();
    IPersonInfo getOwners();
    IPersonInfo getCheckers();
    int getScore();
}
