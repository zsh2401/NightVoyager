package org.nightvoyager.core.event;

/**
 * Just like WPF.
 */
public class PropertyChangedEvent extends Event {
    public String getPropertyName(){
        return propertyName;
    }
    private final String propertyName;
    public PropertyChangedEvent(Object sender,String propertyName){
        super(sender);
        this.propertyName = propertyName;
    }
}
