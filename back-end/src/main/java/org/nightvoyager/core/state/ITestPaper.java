package org.nightvoyager.core.state;

import org.nightvoyager.core.data.qa.IAnswer;
import org.nightvoyager.core.data.qa.IQuestion;
import org.nightvoyager.core.data.qa.ITestPaperMasterCopy;
import org.nightvoyager.core.data.ICandidateInfo;

import java.util.Map;

public interface ITestPaper {

    ICandidateInfo getOwner();

    Map<IQuestion,IAnswer> getFinished();

    void update(IAnswer answer) throws Exception;
    void handedIn() throws Exception;

    ITestPaperMasterCopy getMaster();
    default IQuestion[] getQuestions(){
        return getMaster().getQuestions();
    }
}
