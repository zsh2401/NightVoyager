package org.nightvoyager.core.util;

import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.data.ICandidateInfo;
import org.nightvoyager.core.data.IExaminationInfo;

import java.util.Arrays;
import java.util.stream.Stream;

public class CandidateHelper {
    private CandidateHelper(){}
    /**
     *
     * @author zsh2401
     * @return the relative exam.
     * */
    public static Stream<IExaminationInfo> getExamsRelativeWith(INVSystem system, ICandidateInfo candidate){

        IExaminationInfo[] coming = system.getExamScheduler().getComingExams();
        IExaminationInfo[] ing = system.getExamScheduler().getExaminingExams();

        return Arrays.stream(ArrayHelperKt.concatAll(ing, coming)).filter(
                it-> Arrays.stream(it.getRelativeCandidates())
                .anyMatch(_candidate-> _candidate.getId() == candidate.getId()));
    }
}
