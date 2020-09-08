package org.nightvoyager.core.util;

import org.greenrobot.eventbus.EventBus;

public class Lazy<TValue> {

    private final Factory<TValue> factory;

    @FunctionalInterface
    public interface Factory<T> {
        T getValue();
    }

    private volatile TValue _instance;

    public Lazy(Factory<TValue> factory) {
        this.factory = factory;
    }

    public TValue value() {
        TValue instance = _instance;
        if (instance == null) {
            synchronized (factory) {
                instance = _instance;
                if (instance == null) {
                    instance = _instance = factory.getValue();
                }
            }
        }
        return instance;
    }
}
