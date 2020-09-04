package org.nightvoyager.core.support;

import org.greenrobot.eventbus.EventBus;
import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.data.registries.ITestPaperMasterCopyRegistry;
import org.nightvoyager.core.event.TickLoopStartupEvent;
import org.nightvoyager.core.event.TickLoopStoppedEvent;
import org.nightvoyager.core.ext.IPluginManager;
import org.nightvoyager.core.ext.standard.Proctor;
import org.nightvoyager.core.ext.standard.SaveStateEventScheduler;
import org.nightvoyager.core.ext.standard.PerformanceAnalyzer;
import org.nightvoyager.core.state.ICandidatesManager;
import org.nightvoyager.core.state.IExamScheduler;
import org.nightvoyager.core.state.PreTickEvent;
import org.nightvoyager.core.state.TickEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NVSystem implements INVSystem {

    private final ITestPaperMasterCopyRegistry testPaperMasterCopyRegistry;
    private final IPluginManager pluginManager;
    private final EventBus eventBus;
    private final ICandidatesManager candidatesManager;
    private final IExamScheduler scheduler;
    private final Logger logger;

    public NVSystem(ICandidatesManager candidatesManager) {
        testPaperMasterCopyRegistry = createTestPaperMasterCopyRegistry();
        pluginManager = createPluginManager();
        eventBus = createEventBus();
        this.candidatesManager = candidatesManager;
        logger = createLogger();
        scheduler = createExamScheduler();
        eventBus.register(this);
        loadDefaultPlugins(this.getPluginManager());
    }
    protected org.slf4j.Logger createLogger(){
        return LoggerFactory.getLogger(NVSystem.class);
    }
    protected ITestPaperMasterCopyRegistry createTestPaperMasterCopyRegistry(){
        return new TestPaperMCRegistry();
    }
    protected IPluginManager createPluginManager(){
        return new PluginManager(this);
    }
    protected EventBus createEventBus(){
        return new EventBus();
    }
    protected IExamScheduler createExamScheduler(){
        return new ExamScheduler(this);
    }

    protected void loadDefaultPlugins(IPluginManager pm){
        pm.load(Proctor.class);
        pm.load(SaveStateEventScheduler.class);
        pm.load(PerformanceAnalyzer.class);
    }

    @Override
    public ITestPaperMasterCopyRegistry getTestPaperMCRegistry() {
        return testPaperMasterCopyRegistry;
    }

    @Override
    public IPluginManager getPluginManager() {
        return this.pluginManager;
    }

    @Override
    public IExamScheduler getExamScheduler() {
        return this.scheduler;
    }

    @Override
    public ICandidatesManager getCandidatesManager() {
        return this.candidatesManager;
    }

    @Override
    public EventBus getEventBus() {
       return this.eventBus;
    }

    @Override
    public void loop() {
        getEventBus().postSticky(new TickLoopStartupEvent(this));

        TickEvent tickEvent = null;
        PreTickEvent preEvent = null;
        long start,end;
        do{
            start = System.currentTimeMillis();

            preEvent = new PreTickEvent(this);
            getEventBus().post(preEvent);
            if(preEvent.isNextTickCancelled()){
                continue;
            }

            tickEvent = new TickEvent(this);
            getEventBus().post(tickEvent);

            end = System.currentTimeMillis();

            if(end - start > 0){
                try {
                    Thread.sleep(end - start);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }

        }while (tickEvent.couldContinue());

        getEventBus().postSticky(new TickLoopStoppedEvent(this));
    }
}
