package org.nightvoyager.core.data.roler;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import javax.naming.OperationNotSupportedException;
import javax.persistence.Column;
import java.util.Arrays;
import java.util.List;

public interface IPersonInfo {

    /**
     * Get candidate's Id.
     *
     * @return candidate's Id.
     */
    @NotNull
    @JsonProperty("id")
    @Column(name="id")
    String getId();

    /**
     * @return candidate's full name.
     */
    @NotNull
    @JsonProperty("name")
    @Column(name="name")
    String getName();

    /**
     * Set name
     *
     * @param name
     * @throws OperationNotSupportedException readonly or other reason.
     */
    @JsonProperty("name")
    void setName(String name) throws OperationNotSupportedException;

    /**
     * Get permission.
     * e.g: 0x777
     *
     * @return
     */
    @JsonProperty("permissions")
    @Column(name="permissions")
    String[] getPermissions();

    /**
     * Set permission.
     *
     * @param permissions
     * @throws OperationNotSupportedException readonly or other reason.
     * @throws IllegalArgumentException       permission value is invalid.
     */
    @JsonProperty("permissions")
    void setPermissions(String[] permissions);

    default void addPermissions(String... adding){
        synchronized (this) {
            final String[] convert = new String[0];
            List<String> builder = Arrays.asList(getPermissions());
            builder.addAll(Arrays.asList(adding));
            setPermissions(builder.toArray(convert));
        }
    }

    default void removePermissions(String... removing){
        synchronized (this){
            final String[] convert = new String[0];
            List<String> builder = Arrays.asList(getPermissions());
            builder.removeAll(Arrays.asList(removing));
            setPermissions(builder.toArray(convert));
        }
    }

    default boolean hasPermission(String permission){
        return Arrays.stream(getPermissions()).anyMatch(it->it == permission);
    }
}
