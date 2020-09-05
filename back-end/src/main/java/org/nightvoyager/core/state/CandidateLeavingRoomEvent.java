package org.nightvoyager.core.state;

import org.nightvoyager.core.data.IExaminationInfo;
import org.nightvoyager.core.data.rolers.ICandidateInfo;
import org.nightvoyager.core.event.CancelableNVSystemEvent;

public class CandidateLeavingRoomEvent extends CancelableNVSystemEvent {
    private final ICandidateInfo candidate;
    private final IExaminationInfo room;
    public CandidateLeavingRoomEvent(ICandidateInfo candidate, IExaminationInfo room){
        super(room,room.getSystem());
        this.candidate = candidate;
        this.room = room;
    }
}
