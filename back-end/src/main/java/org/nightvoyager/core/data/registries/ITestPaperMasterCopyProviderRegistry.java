package org.nightvoyager.core.data.registries;

public interface ITestPaperMasterCopyProviderRegistry {
    ITestPaperMasterCopyProvider[] getProviders();
    void register(ITestPaperMasterCopyProvider provider);
    void unregister(ITestPaperMasterCopyProvider provider);
}
