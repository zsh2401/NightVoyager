package org.nightvoyager.core.state;

import org.nightvoyager.core.data.roler.IPersonInfo;

import java.util.Arrays;

public interface ICandidatesManager {
    IPersonInfo[] getCandidates();
    default IPersonInfo getCandidateById(String id){
        return (IPersonInfo) (Arrays.stream(getCandidates()).filter(it->{
            return it.getId() == id;
        }).toArray()[0]);
    }
}
