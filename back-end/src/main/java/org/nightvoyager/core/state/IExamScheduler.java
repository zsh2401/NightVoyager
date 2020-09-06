package org.nightvoyager.core.state;

import org.nightvoyager.core.data.IExaminationInfo;
import org.nightvoyager.core.util.IEventDriven;

import java.util.List;

public interface IExamScheduler extends IEventDriven {

    enum ExamState{
        COMING,
        PASTED,
        EXAMINING,
        ALL
    }

    List<? extends  IExaminationInfo> getExams(ExamState state);

    /**
     * Get all exams.
     * @return
     */
    List<? extends IExaminationInfo> getExams();

    /**
     * Register new examination to scheduler.
     * @param exam
     * @throws IllegalArgumentException examination has already been registered in scheduler.
     */
    void register(IExaminationInfo exam) throws IllegalArgumentException;


    /**
     * Unregister an registered examination from scheduled plan.
     * @param exam
     * @throws IllegalArgumentException examination has not been registered in scheduler.
     */
    void unregister(IExaminationInfo exam) throws IllegalArgumentException;

}
