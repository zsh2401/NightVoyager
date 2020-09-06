package org.nightvoyager.core.state;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.nightvoyager.core.data.IExaminationInfo;
import org.nightvoyager.core.event.NVSystemEvent;

public class ExamEndEvent extends NVSystemEvent {
    private final IExaminationRoom room;

    public ExamEndEvent(IExaminationRoom room) {
        super(room,room.getSystem());
        this.room = room;
    }

    public IExaminationRoom getRoom() {
        return room;
    }
}
