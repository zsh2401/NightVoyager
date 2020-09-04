package org.nightvoyager.core.data.qa;

import org.nightvoyager.core.util.metadata.ISupportMetadata;
import org.nightvoyager.core.util.metadata.Metadata;

public interface ITestPaperMasterCopy extends ISupportMetadata {

    IQuestion[] getQuestions();

    default String getId(){
        return this.getMetadata().id();
    }

    default String getTitle(){
        final String DEFAULT_TITLE = "Unknown";
        try {
            return this.getMetadata().getValue(Metadata.KEY_TITLE,String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return DEFAULT_TITLE;
        }
    }

    long UNLIMITED = -1;
    default long getTimeLimit(){
        try {
            return this.getMetadata().getValue(Metadata.KEY_TITLE,long.class);
        } catch (Exception e) {
            e.printStackTrace();
            return UNLIMITED;
        }
    }
}
