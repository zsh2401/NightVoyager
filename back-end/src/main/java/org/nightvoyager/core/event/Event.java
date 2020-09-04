package org.nightvoyager.core.event;

/**
 * All event's base class in Night Voyager System.
 */
public abstract class Event {
    private final Object sender;
    protected Event(Object sender){
        this.sender = sender;
    }
    protected Event(){
        this(null);
    }

    public Object getSender(){
        return sender;
    }
}
