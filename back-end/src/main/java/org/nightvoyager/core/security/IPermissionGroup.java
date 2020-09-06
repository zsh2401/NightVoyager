package org.nightvoyager.core.security;

import org.nightvoyager.core.data.IUnique;

public interface IPermissionGroup extends IUnique, IPermissionComponent {

    String getName();

}
