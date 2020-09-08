package org.nightvoyager.core.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.nightvoyager.core.data.IUnique;
import org.nightvoyager.core.security.IPermissionComponent;

import javax.naming.OperationNotSupportedException;

public interface IPersonInfo extends IUnique, IPermissionComponent {
    /**
     * @return candidate's full name.
     */
    @NotNull
    @JsonProperty("name")
    String getName();

    /**
     * Set name
     *
     * @param name
     * @throws OperationNotSupportedException readonly or other reason.
     */
    @JsonProperty("name")
    void setName(String name) throws OperationNotSupportedException;
}
