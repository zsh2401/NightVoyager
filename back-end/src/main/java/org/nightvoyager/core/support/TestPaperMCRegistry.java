package org.nightvoyager.core.support;

import org.nightvoyager.core.data.qa.ITestPaperInfo;
import org.nightvoyager.core.data.ITestPaperRegistry;

import java.util.ArrayList;
import java.util.List;

public class TestPaperMCRegistry implements ITestPaperRegistry {

    @Override
    public ITestPaperInfo[] getAllTestPaper() {
        return testPaperMasterCopies.toArray(new ITestPaperInfo[0]);
    }
    final List<ITestPaperInfo> testPaperMasterCopies = new ArrayList<>();

    @Override
    public synchronized void register(ITestPaperInfo t) {
        testPaperMasterCopies.add(t);
    }

    @Override
    public synchronized void unregister(ITestPaperInfo t) {
        testPaperMasterCopies.remove(t);
    }
}
