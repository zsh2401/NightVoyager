package org.nightvoyager.core.support;

import org.greenrobot.eventbus.Subscribe;
import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.data.qa.ITestPaperInfo;
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
    public void onTick(TickEvent e) {

    }

    private void startExam(IExaminationInfo exam){

    }


    private static final IExaminationInfo[] _covert = new IExaminationInfo[0];


    @Override
    public IExaminationInfo[] getExams(ExamState state) {
        return new IExaminationInfo[0];
//        return this.system.getDataAccessor().getExaminations();
    }

    @Override
    public IExaminationInfo[] getExams() {
        return this.system.getDataAccessor().getExaminations();
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
