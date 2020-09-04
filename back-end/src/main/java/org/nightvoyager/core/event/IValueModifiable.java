package org.nightvoyager.core.event;

public interface IValueModifiable<T> {
    T getEventRelativeValue();
    void setEventRelativeValue(T v);
}
