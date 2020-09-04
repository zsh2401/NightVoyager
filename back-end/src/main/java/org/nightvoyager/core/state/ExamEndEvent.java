package org.nightvoyager.core.state;

import org.nightvoyager.core.data.IExaminationInfo;
import org.nightvoyager.core.event.NVSystemEvent;

public class ExamEndEvent extends NVSystemEvent {
    private final IExaminationInfo room;

    public ExamEndEvent(IExaminationInfo room) {
        super(room,room.getSystem());
        this.room = room;
    }

    public IExaminationInfo getRoom() {
        return room;
    }
}
