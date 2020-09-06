package org.nightvoyager.core.state;

import org.nightvoyager.core.data.IExaminationInfo;
import org.nightvoyager.core.event.NVSystemEvent;

public class ExamBeginEvent extends NVSystemEvent {
    private final IExaminationRoom room;

    public ExamBeginEvent(IExaminationRoom room) {
        super(room, room.getSystem());
        this.room = room;
    }

    public IExaminationRoom getRoom() {
        return room;
    }
}
