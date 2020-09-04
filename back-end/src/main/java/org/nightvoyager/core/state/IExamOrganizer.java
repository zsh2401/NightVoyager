package org.nightvoyager.core.state;

import org.nightvoyager.core.data.IExaminationInfo;

import java.util.Date;

public interface IExamOrganizer {
    IExaminationInfo newExam(
            ITestPaper[] testPapers,
            String[] candidateIds,
            Date startTime,long duration);
}
