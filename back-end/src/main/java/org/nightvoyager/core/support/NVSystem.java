package org.nightvoyager.core.support;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;
import org.jetbrains.annotations.NotNull;
import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.data.IDataAccessor;
import org.nightvoyager.core.data.ITestPaperRegistry;
import org.nightvoyager.core.event.TickLoopStartupEvent;
import org.nightvoyager.core.event.TickLoopStoppedEvent;
import org.nightvoyager.core.ext.IPluginManager;
import org.nightvoyager.core.ext.standard.Proctor;
import org.nightvoyager.core.ext.standard.IOScheduler;
import org.nightvoyager.core.ext.standard.PerformanceAnalyzer;
import org.nightvoyager.core.state.*;
import org.nightvoyager.core.util.IEventDriven;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Standard implementation of Night Voyager System .(Extensible)
 */
public class NVSystem extends Object implements INVSystem, IEventDriven {

    private static final String SQLITE_DB_FILE_NAME = "./nv.db";

    private final ITestPaperRegistry testPaperMasterCopyRegistry;
    private final IPluginManager pluginManager;
    private final EventBus eventBus;
    private final ICandidatesManager candidatesManager;
    private final IExamScheduler scheduler;
    private final Logger logger;
    private final IDataAccessor dataAccessor;


    public NVSystem() {
        eventBus = createEventBus();
        testPaperMasterCopyRegistry = createTestPaperMasterCopyRegistry();
        pluginManager = createPluginManager();
        candidatesManager = createCandidatesManager();
        logger = createLogger();
        scheduler = createExamScheduler();
        try{
            eventBus.register(this);
        }catch (EventBusException e){}
        dataAccessor = createDataAccessor();
        loadDefaultPlugins(this.getPluginManager());
    }

    protected org.slf4j.Logger createLogger() {
        return LoggerFactory.getLogger(NVSystem.class);
    }

    protected ITestPaperRegistry createTestPaperMasterCopyRegistry() {
        return new TestPaperMCRegistry();
    }

    protected IPluginManager createPluginManager() {
        return new PluginManager(this);
    }

    protected EventBus createEventBus() {
        return new EventBus();
    }

    protected IExamScheduler createExamScheduler() {
        return new ExamScheduler(this);
    }

    protected ICandidatesManager createCandidatesManager() {
        return new CandidatesManager(this);
    }

    protected IDataAccessor createDataAccessor(){
        return null;
    }

    /**
     * Load default plugins to system.
     * It should be called only once in whole system lifecycle!
     * @param pm
     */
    protected void loadDefaultPlugins(IPluginManager pm) {
        pm.load(Proctor.class);
        pm.load(IOScheduler.class);
        pm.load(PerformanceAnalyzer.class);
    }

    @NotNull
    @Override
    public ITestPaperRegistry getTestPaperMCRegistry() {
        return testPaperMasterCopyRegistry;
    }

    @NotNull
    @Override
    public IPluginManager getPluginManager() {
        return this.pluginManager;
    }

    @NotNull
    @Override
    public IDataAccessor getDataAccessor() {
        return this.dataAccessor;
    }

    @NotNull
    @Override
    public IExamScheduler getExamScheduler() {
        return this.scheduler;
    }

    @NotNull
    @Override
    public ICandidatesManager getCandidatesManager() {
        return this.candidatesManager;
    }

    @NotNull
    @Override
    public EventBus getEventBus() {
        return this.eventBus;
    }

    @Override
    public void loop() {
        getEventBus().postSticky(new TickLoopStartupEvent(this));

        while (fullTick()) ;

        getEventBus().postSticky(new TickLoopStoppedEvent(this));
    }

    /**
     * Do what 1 tick should.
     *
     * @return true if next tick is allowed.
     */
    protected boolean fullTick() {
        final long MAX_TICK_TIME = 1000 / INVSystem.DEFAULT_TICK_PER_SECOND;
        long start, usedTime;

        start = System.currentTimeMillis();

        boolean couldContinue = onTick(new TickEvent(this));

        usedTime = System.currentTimeMillis() - start;
        if (MAX_TICK_TIME > usedTime) {
            planRemainingTime(MAX_TICK_TIME - usedTime);
        }

        usedTime = System.currentTimeMillis() - start;
        if (MAX_TICK_TIME > usedTime) {
            wasteRemainingTime(MAX_TICK_TIME - usedTime);
        }

        return couldContinue;
    }


    /**
     * Post tick event.
     *
     * @return true if the next tick is allowed to execute.
     */
    protected boolean onTick(TickEvent e) {
        getEventBus().post(e);
        return e.couldContinue();
    }

    /**
     * Some times tick has not use all time allocate for it.
     * To make TPS stable, there is remaining time could use for other things.
     * If there is still remaining time, it will be wasted in Thread.sleep()
     *
     * @param remainingTime
     */
    protected void planRemainingTime(long remainingTime) {
//        final long avgTickTime =  1000 / INVSystem.DEFAULT_TICK_PER_SECOND;
//        if(remainingTime < avgTickTime){
//            try {
//                Thread.sleep(end - usedTime);
//            } catch (InterruptedException interruptedException) {
//                interruptedException.printStackTrace();
//            }
//        }
    }

    /**
     * Waste time.
     *
     * @param remainingTime
     */
    protected void wasteRemainingTime(long remainingTime) {
        final long IGNORABLE_TIME = 5;
        if (remainingTime >= IGNORABLE_TIME) {
            try {
                Thread.sleep(remainingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
