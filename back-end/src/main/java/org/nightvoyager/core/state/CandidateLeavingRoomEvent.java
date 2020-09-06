package org.nightvoyager.core.state;

import org.nightvoyager.core.data.roler.IPersonInfo;
import org.nightvoyager.core.event.CancelableNVSystemEvent;

public class CandidateLeavingRoomEvent extends CancelableNVSystemEvent {
    private final IPersonInfo candidate;
    private final IExaminationRoom room;
    public CandidateLeavingRoomEvent(IPersonInfo candidate, IExaminationRoom room){
        super(room,room.getSystem());
        this.candidate = candidate;
        this.room = room;
    }
}
