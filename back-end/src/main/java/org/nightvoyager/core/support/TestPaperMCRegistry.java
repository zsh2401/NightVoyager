package org.nightvoyager.core.support;

import org.nightvoyager.core.data.ITestPaperMasterCopy;
import org.nightvoyager.core.data.ITestPaperRegistry;

import java.util.ArrayList;
import java.util.List;

public class TestPaperMCRegistry implements ITestPaperRegistry {

    @Override
    public ITestPaperMasterCopy[] getAllTestPaper() {
        return testPaperMasterCopies.toArray(new ITestPaperMasterCopy[0]);
    }
    final List<ITestPaperMasterCopy> testPaperMasterCopies = new ArrayList<>();

    @Override
    public synchronized void register(ITestPaperMasterCopy t) {
        testPaperMasterCopies.add(t);
    }

    @Override
    public synchronized void unregister(ITestPaperMasterCopy t) {
        testPaperMasterCopies.remove(t);
    }
}
