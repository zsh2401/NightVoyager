package org.nightvoyager.core.ext.standard;

import org.greenrobot.eventbus.Subscribe;
import org.nightvoyager.core.data.ICandidateInfo;
import org.nightvoyager.core.ext.NVPlugin;
import org.nightvoyager.core.ext.Plugin;
import org.nightvoyager.core.state.CandidateEnteringRoomEvent;
import org.nightvoyager.core.state.CandidateLeavingRoomEvent;
import org.nightvoyager.core.data.IExaminationInfo;
import org.nightvoyager.core.state.IExaminationRoom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Make sure that candidates could enter an examination.
 */
@NVPlugin
public class Proctor extends Plugin {

    private static final Logger logger = LoggerFactory.getLogger(Proctor.class);

    @Subscribe
    public void onCandidateEnter(final CandidateEnteringRoomEvent e) {
        try {
            final IExaminationRoom room = e.getRoom();
            final IExaminationInfo examInfo = room.getInfo();
            final ICandidateInfo candidateInfo = e.getCandidate();

            boolean isRelated = false;
            for (ICandidateInfo currentCandidate : examInfo.getRelativeCandidates()) {
                if (Objects.equals(currentCandidate.getId(),currentCandidate.getId())) {
                    isRelated = true;
                    break;
                }
            }
            e.setCancel(!isRelated);

        } catch (Exception exception) {
            logger.error("", exception);
        }
    }

    public void onCandidateLeaving(final CandidateLeavingRoomEvent e) {
        try {

        } catch (Exception exception) {
            logger.error("", exception);
        }
    }
}
