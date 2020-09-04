package org.nightvoyager.core.state;

import org.nightvoyager.core.data.ICandidateInfo;
import org.nightvoyager.core.event.CancelableNVSystemEvent;

public class CandidateEnteringRoomEvent extends CancelableNVSystemEvent {

    private static final CancelMode DEFAULT_CANCEL_MODE = CancelMode.ONE_VOTE_TO_CANCEL;

    private final ICandidateInfo candidate;
    private final IExaminationRoom room;

    public CandidateEnteringRoomEvent(ICandidateInfo candidate, IExaminationRoom room) {
        super(room, room.getInfo().getSystem());
        this.candidate = candidate;
        this.room = room;
        this.setCancelMode(DEFAULT_CANCEL_MODE);
    }

    public ICandidateInfo getCandidate() {
        return candidate;
    }

    public IExaminationRoom getRoom() {
        return room;
    }
}
