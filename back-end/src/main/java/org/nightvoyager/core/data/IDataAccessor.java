package org.nightvoyager.core.data;

import org.nightvoyager.core.data.qa.IAnswer;
import org.nightvoyager.core.data.qa.IQuestion;
import org.nightvoyager.core.data.qa.ITestPaperInfo;
import org.nightvoyager.core.data.roler.IPersonInfo;
import org.nightvoyager.core.data.roler.Permissions;
import org.nightvoyager.core.state.IEventDriven;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;


/**
 * DAO
 */
public interface IDataAccessor extends IEventDriven {

    List<? extends IExaminationInfo> getExaminations();
    void addOrUpdate(IExaminationInfo... exam);
    void remove(IExaminationInfo... exam);

    List<? extends IPersonInfo> getPersons();
    default List<? extends IPersonInfo> getCandidates(){
        return getPersons()
                .stream()
                .filter(it->it.hasPermission(Permissions.ROLE_CANDIDATE))
                .collect(Collectors.toList());
    }
    void addOrUpdate(IPersonInfo... personInfo);
    void remove(IPersonInfo... personInfo);

    List<? extends ITestPaperInfo> getTestPapers();
    void addOrUpdate(ITestPaperInfo... testPaperMasterCopy);
    void remove(ITestPaperInfo... testPaperMasterCopy);

    List<? extends IQuestion> getQuestions();
    void addOrUpdate(IQuestion... questions);
    void remove(IQuestion... questions);

    List<? extends IResult> getResults();
    void addOrUpdate(IResult... results);
    void remove(IResult... results);

    List<? extends IAnswer> getAnswers();
    void addOrUpdate(IAnswer... answers);
    void remove(IAnswer... answers);

    Properties getProperties();

    void sync();

    default String[] getDefaultPermissions(){
        return Permissions.DEFAULT_CANDIDATE_PERMISSIONS;
    }
}
