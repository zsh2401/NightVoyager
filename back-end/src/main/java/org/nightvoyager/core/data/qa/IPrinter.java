package org.nightvoyager.core.data.qa;

import org.nightvoyager.core.state.ITestPaper;

public interface IPrinter {
    ITestPaper getCopies(ITestPaperMasterCopy masterCopy);
}
