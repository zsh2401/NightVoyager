package org.nightvoyager.core.event;

import org.nightvoyager.core.INVSystem;

/**
 * Cancelable Event(Support set or get value that dedicates value of if cancel.)
 */
public class CancelableNVSystemEvent extends NVSystemEvent implements ICancelable {

    private static final CancelMode DEFAULT_CANCEL_MODE = CancelMode.ONE_VOTE_TO_CANCEL;
    private static final boolean DEFAULT_CANCEL_VALUE = false;
    private static final boolean COULD_RESET_CANCEL_MODE = true;

    public static enum CancelMode {
        DEFAULT,
        ONE_VOTE_TO_CANCEL,
        ONE_VOTE_TO_NO_CANCEL,
    }

    private CancelMode mode = DEFAULT_CANCEL_MODE;
    private boolean cancel = DEFAULT_CANCEL_VALUE;
    private boolean cancelModeSet = false;

    public CancelableNVSystemEvent(INVSystem sm) {
        super(sm);
    }

    public CancelableNVSystemEvent(Object sender, INVSystem sm) {
        super(sender, sm);
    }

    protected void setCancelMode(CancelMode cancelMode) {
        //Always true.
        if (!cancelModeSet || COULD_RESET_CANCEL_MODE) {
            this.mode = cancelMode;
            cancelModeSet = true;
        }
    }

    public CancelMode getCancelMode() {
        return this.mode;
    }


    @Override
    public boolean isCancel() {
        return cancel;
    }

    @Override
    public void setCancel(boolean value) {
        switch (mode) {
            case ONE_VOTE_TO_CANCEL:
                cancel = cancel || value;
            case ONE_VOTE_TO_NO_CANCEL:
                cancel = cancel && value;
            case DEFAULT:
            default:
                cancel = value;
                break;
        }
    }
}
