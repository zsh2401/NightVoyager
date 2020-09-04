package org.nightvoyager.core.data.qa;

import org.nightvoyager.core.data.ICandidateInfo;
import org.nightvoyager.core.state.ITestPaper;

public interface IAnswer {
    IQuestion getOwner();
    ITestPaper getTestPaper();
    String getTextContent();
    ICandidateInfo getCandidate();
    long getOptions();
}
