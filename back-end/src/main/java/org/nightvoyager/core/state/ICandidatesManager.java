package org.nightvoyager.core.state;

import org.nightvoyager.core.data.IExaminationInfo;
import org.nightvoyager.core.data.ICandidateInfo;

import java.util.Arrays;

public interface ICandidatesManager {
    ICandidateInfo[] getCandidates();
    default ICandidateInfo getCandidateById(String id){
        return (ICandidateInfo) (Arrays.stream(getCandidates()).filter(it->{
            return it.getId() == id;
        }).toArray()[0]);
    }
}
