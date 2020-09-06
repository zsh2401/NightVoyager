package org.nightvoyager.core.support;

import org.greenrobot.eventbus.Subscribe;
import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.data.roler.IPersonInfo;
import org.nightvoyager.core.event.ReadStateEvent;
import org.nightvoyager.core.event.SaveStateEvent;
import org.nightvoyager.core.state.ICandidatesManager;

import java.util.List;

public class CandidatesManager extends NVSystemObject implements ICandidatesManager {
    public CandidatesManager(INVSystem system) {
        super(system);
    }

    private List<? extends IPersonInfo> cache;

    @Subscribe
    public void onSaveState(SaveStateEvent e) {
        getNVSystem().getDataAccessor().getCandidates();
    }

    @Subscribe
    public void onReadState(ReadStateEvent e) {
        readState();
    }

    private synchronized void readState(){
        cache = getNVSystem().getDataAccessor().getCandidates();
    }

    @Override
    public List<? extends IPersonInfo> getCandidates() {
        if(cache == null){
            readState();
        }
        return cache;
    }
}
