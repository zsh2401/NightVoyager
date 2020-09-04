package org.nightvoyager.core.state;

import org.nightvoyager.core.data.IExaminationInfo;
import org.nightvoyager.core.data.ICandidateInfo;

public interface IExaminationRoom {
    IExaminationInfo getInfo();

    /**
     * Get candidate who is in room currently.
     *
     * @return
     */
    ICandidateInfo[] getInRoomCandidates();

    /**
     * Get candidate who is once enter this exam room.(Now still in or not.)
     *
     * @return
     */
    ICandidateInfo[] getHaveTakenTheExamCandidates();

    /**
     * Get handed in test papers.
     *
     * @return
     */
    ITestPaper[] getHandIn();

    /**
     * Candidate enter this room.
     *
     * @param candidate
     * @exception IllegalStateException The candidate could not enter this room.
     * @exception IllegalAccessException The candidate has no permission.
     */
    void enter(ICandidateInfo candidate) throws IllegalStateException,IllegalAccessException;

    /**
     * Candidate leave this room.
     *
     * @param candidate
     * @exception IllegalStateException The candidate could not leave this room.
     * @exception IllegalAccessException The candidate has no permission.
     */
    void leave(ICandidateInfo candidate);
}
