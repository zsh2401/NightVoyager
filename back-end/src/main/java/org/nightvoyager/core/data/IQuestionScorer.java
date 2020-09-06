package org.nightvoyager.core.data;

public interface IQuestionScorer extends IUnique {
    IResult handle(IAnswer answer);
    enum Type{
        JavaClass,
        ExternalWebAPI
    }
}
