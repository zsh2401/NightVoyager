package org.nightvoyager.core.data.registries;

import org.nightvoyager.core.data.qa.ITestPaperMasterCopy;

public interface ITestPaperMasterCopyRegistry {
    ITestPaperMasterCopy[] getAllTestPaper();
    void register(ITestPaperMasterCopy t);
    void unregister(ITestPaperMasterCopy t);
}
