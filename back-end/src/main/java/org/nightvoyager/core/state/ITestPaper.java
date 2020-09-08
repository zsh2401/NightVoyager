package org.nightvoyager.core.state;

import org.nightvoyager.core.data.IAnswer;
import org.nightvoyager.core.data.IQuestion;
import org.nightvoyager.core.data.IPersonInfo;

import java.util.Map;

public interface ITestPaper {

    ITestPaper getInfo();
    Map<IQuestion, IAnswer> getAnswerMap();
    IPersonInfo getOwner();

}
