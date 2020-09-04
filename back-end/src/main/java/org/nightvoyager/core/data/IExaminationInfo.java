package org.nightvoyager.core.data;

import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.data.qa.ITestPaperMasterCopy;
import org.nightvoyager.core.state.ExaminationState;
import org.nightvoyager.core.state.IExaminationRoom;
import org.nightvoyager.core.state.ITestPaper;
import org.nightvoyager.core.util.metadata.ISupportMetadata;

/**
 * Readonly Examination info.
 * Should be created by some type of builder with data stored in database or file.
 */
public interface IExaminationInfo extends ISupportMetadata {

    INVSystem getSystem();

    ICandidateInfo[] getRelativeCandidates();

    long getStartTime();
    long getTimeLimit();

    default String getDescription(){
        return this.getMetadata().description();
    }

    String KEY_NOTICE = "__exam_notice__";
    default String getNotice(){
        return this.getMetadata().getValue(KEY_NOTICE,"");
    }


    ITestPaperMasterCopy[] getTestPapers();

    IExaminationRoom getRoom() throws IllegalStateException;
}
