package org.nightvoyager.core.util;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactory implements java.util.concurrent.ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    public ThreadFactory(String feature) {
        this.namePrefix = "Night Voyager System Thread Factory For <" + feature +">";
    }

    @Override
    public Thread newThread(@NotNull Runnable r) {
        String name = namePrefix + "-" + nextId.getAndIncrement();
        Thread thread = new Thread(null,r,name);
        return thread;
    }
}
