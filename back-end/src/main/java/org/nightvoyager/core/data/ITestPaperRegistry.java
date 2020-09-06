package org.nightvoyager.core.data;

public interface ITestPaperRegistry {
    ITestPaperMasterCopy[] getAllTestPaper();
    void register(ITestPaperMasterCopy t);
    void unregister(ITestPaperMasterCopy t);
}
