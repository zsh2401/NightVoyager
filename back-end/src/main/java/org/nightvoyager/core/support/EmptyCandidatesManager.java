package org.nightvoyager.core.support;

import org.greenrobot.eventbus.Subscribe;
import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.data.ICandidateInfo;
import org.nightvoyager.core.event.ReadStateEvent;
import org.nightvoyager.core.state.ICandidatesManager;
import org.nightvoyager.core.data.IExaminationInfo;

public class EmptyCandidatesManager extends NVSystemObject implements ICandidatesManager {
    public EmptyCandidatesManager(INVSystem system){
        super(system);
    }

    @Subscribe
    public void onReadState(ReadStateEvent e){

    }
    @Override
    public ICandidateInfo[] getCandidates() {
        return new ICandidateInfo[0];
    }
}
