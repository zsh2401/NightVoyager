package org.nightvoyager.core.util;

public interface ITickWatcher {
    void start() throws IllegalStateException;
    void stop() throws IllegalStateException;
    boolean isRunning();
}
