package org.nightvoyager.core.state;

import org.nightvoyager.core.INVSystem;
import org.nightvoyager.core.data.IExaminationInfo;
import org.nightvoyager.core.data.ITestPaperMasterCopy;
import org.nightvoyager.core.data.roler.IPersonInfo;

import java.util.List;

public interface IExaminationRoom {

    /**
     * Get the examination info about this room
     * @return
     */
    IExaminationInfo getInfo();

    /**
     * Get related system.
     * @return
     */
    INVSystem getSystem();

    /**
     * Get candidate who is in room currently.
     *
     * @return
     */
    List<IPersonInfo> getInRoomCandidates();

    /**
     * Get candidate who is once enter this exam room.(Now still in or not.)
     *
     * @return
     */
    List<IPersonInfo> getHaveTakenTheExamCandidates();

    /**
     * Get handed in test papers.
     *
     * @return
     */
    List<ITestPaperMasterCopy> getHandIn();

    /**
     * Candidate enter this room.
     *
     * @param candidate
     * @exception IllegalStateException The candidate could not enter this room.
     * @exception IllegalAccessException The candidate has no permission.
     */
    void enter(IPersonInfo candidate) throws IllegalStateException,IllegalAccessException;

    /**
     * Candidate leave this room.
     *
     * @param candidate
     * @exception IllegalStateException The candidate could not leave this room.
     * @exception IllegalAccessException The candidate has no permission.
     */
    void leave(IPersonInfo candidate);
}
