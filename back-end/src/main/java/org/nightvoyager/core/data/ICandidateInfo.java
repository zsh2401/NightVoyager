package org.nightvoyager.core.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.nightvoyager.core.util.metadata.ISupportMetadata;

/**
 * Readonly information for one specified candidate.
 */
public interface ICandidateInfo extends ISupportMetadata {
    /**
     * Get candidate's Id.
     *
     * @return candidate's Id.
     */
    @NotNull
    @JsonProperty("id")
    default String getId() {
        return this.getMetadata().id();
    }

    /**
     *
     * @return candidate's full name.
     */
    @NotNull
    @JsonProperty("name")
    default String getName(){
        return this.getMetadata().name();
    }


    /**
     * Check if the specified candidate could participating in more than one examination
     *
     * @return true if the candidate could.
     */
    @JsonProperty("couldShadowClone")
    default boolean isCouldShowClone() {
        return false;
    }
}
