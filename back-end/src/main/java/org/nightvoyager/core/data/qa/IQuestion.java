package org.nightvoyager.core.data.qa;

import org.nightvoyager.core.util.metadata.ISupportMetadata;

public interface IQuestion extends ISupportMetadata {
    default String getId(){
        return getMetadata().id();
    }
    ITestPaperMasterCopy getOwner();
    IQuestionDescriptor getDescriptor();
    IQuestionScorer getScorer();
}
