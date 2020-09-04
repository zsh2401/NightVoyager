package org.nightvoyager.core.data.qa;

public interface IQuestionScorer {
    IQuestion getOwner();
    void handle(IAnswer answer);
}
