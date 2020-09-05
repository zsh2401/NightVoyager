package org.nightvoyager.core.data;

import org.nightvoyager.core.data.qa.ITestPaperInfo;

public interface ITestPaperRegistry {
    ITestPaperInfo[] getAllTestPaper();
    void register(ITestPaperInfo t);
    void unregister(ITestPaperInfo t);
}
