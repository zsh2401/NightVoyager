package org.nightvoyager.core.state;

import org.nightvoyager.core.data.qa.IAnswer;
import org.nightvoyager.core.data.qa.IQuestion;
import org.nightvoyager.core.data.qa.ITestPaperInfo;
import org.nightvoyager.core.data.roler.IPersonInfo;

import java.util.Map;

public interface ITestPaper {

    IPersonInfo getOwner();

    Map<IQuestion,IAnswer> getFinished();

    void update(IAnswer answer) throws Exception;
    void handedIn() throws IllegalStateException;

    int getScore();
    void setScore(int score);

    ITestPaperInfo getMaster();
    default IQuestion[] getQuestions(){
        return getMaster().getQuestions();
    }
}
