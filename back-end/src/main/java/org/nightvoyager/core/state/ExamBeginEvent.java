package org.nightvoyager.core.state;

import org.nightvoyager.core.data.IExaminationInfo;
import org.nightvoyager.core.event.NVSystemEvent;

public class ExamBeginEvent extends NVSystemEvent {
    private final IExaminationInfo room;

    public ExamBeginEvent(IExaminationInfo room) {
        super(room, room.getSystem());
        this.room = room;
    }

    public IExaminationInfo getRoom() {
        return room;
    }
}
