package org.nightvoyager.core.state;

import org.nightvoyager.core.data.roler.IPersonInfo;
import org.nightvoyager.core.event.CancelableNVSystemEvent;

public class CandidateEnteringRoomEvent extends CancelableNVSystemEvent {

    private static final CancelMode DEFAULT_CANCEL_MODE = CancelMode.ONE_VOTE_TO_CANCEL;

    private final IPersonInfo candidate;
    private final IExaminationRoom room;

    public CandidateEnteringRoomEvent(IPersonInfo candidate, IExaminationRoom room) {
        super(room, room.getSystem());
        this.candidate = candidate;
        this.room = room;
        this.setCancelMode(DEFAULT_CANCEL_MODE);
    }

    public IPersonInfo getCandidate() {
        return candidate;
    }

    public IExaminationRoom getRoom() {
        return room;
    }
}
