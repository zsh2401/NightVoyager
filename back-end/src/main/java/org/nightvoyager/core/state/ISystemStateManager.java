package org.nightvoyager.core.state;

import org.nightvoyager.core.data.IExaminationInfo;

public interface ISystemStateManager {
    IExaminationInfo[] getTransactions();
    void initialize();
    void save();
    void restore();
}
