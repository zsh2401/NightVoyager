package org.nightvoyager.core.state;

import org.nightvoyager.core.data.roler.IPersonInfo;

import java.util.List;

public interface ICandidatesManager {
    List<? extends IPersonInfo>  getCandidates();
}
