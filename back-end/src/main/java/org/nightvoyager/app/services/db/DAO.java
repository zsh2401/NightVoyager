package org.nightvoyager.app.services.db;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.nightvoyager.app.entities.PersonInfo;
import org.nightvoyager.core.data.IDataAccessor;
import org.nightvoyager.core.data.IExaminationInfo;
import org.nightvoyager.core.data.IResult;
import org.nightvoyager.core.data.IAnswer;
import org.nightvoyager.core.data.IQuestion;
import org.nightvoyager.core.data.ITestPaperMasterCopy;
import org.nightvoyager.core.data.roler.IPersonInfo;
import org.nightvoyager.core.event.SaveStateEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class DAO implements IDataAccessor {

    @Autowired
    private IPersonRepository personRepo;

    @Autowired
    private EventBus eventBus;

    /**
     * Call by spring container.
     */
    public void initialize(){
        eventBus.register(this);
    }

    /**
     * Call by spring container.
     * @param eventBus
     */
    public void destroy(){
        eventBus.unregister(this);
        flush();
    }

    @Subscribe
    public void onSaveState(SaveStateEvent e){
        flush();
    }

    public void flush(){
        personRepo.flush();
    }
    private List<PersonInfo> covert(IPersonInfo[] persons){
        return Arrays.stream(persons)
                .map(it->PersonInfo.valueOf(it))
                .collect(Collectors.toList());
    }

    @Override
    public List<? extends IExaminationInfo> getExaminations() {
        return null;
    }

    @Override
    public void addOrUpdate(IExaminationInfo... exam) {

    }

    @Override
    public void remove(IExaminationInfo... exam) {

    }

    @Override
    public List<? extends IPersonInfo> getPersons() {
        return personRepo.findAll();
    }

    @Override
    public void addOrUpdate(IPersonInfo... persons) {
        personRepo.saveAll(covert(persons));
    }

    @Override
    public void remove(IPersonInfo... persons) {
        personRepo.deleteAll(covert(persons));
    }

    @Override
    public List<? extends ITestPaperMasterCopy> getTestPapers() {
        return null;
    }

    @Override
    public void addOrUpdate(ITestPaperMasterCopy... testPaperMasterCopy) {

    }

    @Override
    public void remove(ITestPaperMasterCopy... testPaperMasterCopy) {

    }

    @Override
    public List<? extends IQuestion> getQuestions() {
        return null;
    }

    @Override
    public void addOrUpdate(IQuestion... questions) {

    }

    @Override
    public void remove(IQuestion... questions) {

    }

    @Override
    public List<? extends IResult> getResults() {
        return null;
    }

    @Override
    public void addOrUpdate(IResult... results) {

    }

    @Override
    public void remove(IResult... results) {

    }

    @Override
    public List<? extends IAnswer> getAnswers() {
        return null;
    }

    @Override
    public void addOrUpdate(IAnswer... answers) {

    }

    @Override
    public void remove(IAnswer... answers) {

    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void sync() {

    }
}
