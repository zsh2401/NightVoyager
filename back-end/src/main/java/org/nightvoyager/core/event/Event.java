package org.nightvoyager.core.event;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * All event's base class in Night Voyager System.
 */
public abstract class Event {

    private final DateTime raiseTime;
    private final Object sender;

    public Event(Object sender){
        this.sender = sender;
        this.raiseTime = DateTime.now();
    }

    public Event(){
        this(null);
    }

    public Object getSender(){
        return sender;
    }

    public DateTime getRaiseTime() {
        return raiseTime;
    }
}
