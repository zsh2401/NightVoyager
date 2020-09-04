package org.nightvoyager.core.support;

import org.greenrobot.eventbus.Subscribe;
import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.data.qa.ITestPaperMasterCopy;
import org.nightvoyager.core.event.ReadStateEvent;
import org.nightvoyager.core.event.SaveStateEvent;
import org.nightvoyager.core.state.IExamScheduler;
import org.nightvoyager.core.data.IExaminationInfo;
import org.nightvoyager.core.state.TickEvent;

import java.util.LinkedList;
import java.util.List;

public class ExamScheduler implements IExamScheduler {

    private final INVSystem system;

    protected List<IExaminationInfo> examinations;
    protected List<IExaminationInfo> coming;
    protected List<IExaminationInfo> examining;

    public ExamScheduler(INVSystem system) {
        this.system = system;
        examinations = new LinkedList<>();
        coming = new LinkedList<>();
        examining = new LinkedList<>();
        system.getEventBus().register(this);
    }

    @Subscribe
    public final synchronized void onSaveState(SaveStateEvent e) {
        saveState();
    }

    @Subscribe
    public final synchronized void onReadState(ReadStateEvent e) {
        readState();
    }

    protected void saveState() {
        //Save state to DataBase or other place.
    }

    protected void readState() {
        //Read state from Database or other place.
    }

    @Subscribe
    public synchronized void onTick(TickEvent e) {

    }

    private void startExam(IExaminationInfo exam){

    }


    private static final IExaminationInfo[] _covert = new IExaminationInfo[0];

    @Override
    public IExaminationInfo[] getComingExams() {
        return (IExaminationInfo[]) examinations
                .stream()
                .filter(
                        it -> it.getStartTime() > System.currentTimeMillis()).toArray();
    }

    @Override
    public IExaminationInfo[] getPastedExams() {
        return (IExaminationInfo[]) examinations
                .stream()
                .filter(
                        it -> {
                            boolean isStarted = it.getStartTime() < System.currentTimeMillis();
                            boolean isUnlimited = it.getTimeLimit() == ITestPaperMasterCopy.UNLIMITED;
                            boolean inDur = it.getStartTime() + it.getTimeLimit() > System.currentTimeMillis();
                            return isStarted && !(isUnlimited || inDur);
                        }).toArray();
    }

    @Override
    public IExaminationInfo[] getExaminingExams() {
        return (IExaminationInfo[]) examinations
                .stream()
                .filter(
                        it -> {
                            boolean isStarted = it.getStartTime() < System.currentTimeMillis();
                            boolean isUnlimited = it.getTimeLimit() == ITestPaperMasterCopy.UNLIMITED;
                            boolean inDur = it.getStartTime() + it.getTimeLimit() > System.currentTimeMillis();
                            return isStarted && (isUnlimited || inDur);
                        }).toArray();
    }

    @Override
    public synchronized void register(IExaminationInfo exam) throws IllegalArgumentException {
        examinations.add(exam);
    }

    @Override
    public synchronized void unregister(IExaminationInfo exam) throws IllegalArgumentException {
        examinations.add(exam);
    }

}
