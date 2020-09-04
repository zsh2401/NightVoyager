package org.nightvoyager.core.state;

import org.nightvoyager.core.data.IExaminationInfo;

public interface IExamScheduler {

    /**
     * @return Those exams will start in the future.
     */
    IExaminationInfo[] getComingExams();


    /**
     * @return Those exams is past or abandoned.
     */
    IExaminationInfo[] getPastedExams();


    /**
     * @return Those exams is in progress
     */
    IExaminationInfo[] getExaminingExams();


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
