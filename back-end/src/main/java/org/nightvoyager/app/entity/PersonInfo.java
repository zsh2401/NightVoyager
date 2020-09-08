package org.nightvoyager.app.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nightvoyager.core.data.IPersonInfo;
import org.nightvoyager.core.security.IPermissionComponent;
import org.nightvoyager.core.security.IPermissionSet;
import org.nightvoyager.core.security.Permissions;

import javax.naming.OperationNotSupportedException;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;

@Entity
@Table(name = "persons")
public class PersonInfo implements IPersonInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "permissions", nullable = false)
    private String permissions = Permissions.toString(Permissions.DEFAULT_CANDIDATE_PERMISSIONS);

    @Column(nullable = false)
    private String name = "";

    @Column(nullable = false)
    private String passwd;

    private String[] getPermissionsAsArray(){
        return new String[0];
    }

    @NotNull
    @Override
    public long getId() {
        return this.id;
    }

    /**
     * Create by <see>IPersonInfo</see>
     * @param personInfo
     */
    private PersonInfo(IPersonInfo personInfo) {
        this.id = personInfo.getId();
        try {
            this.setName(personInfo.getName());
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Preparing for ORM framework
     * DO NOT USE THIS CONSTRUCTOR for create new instance manually
     */
    public PersonInfo() {
    }

    public static PersonInfo valueOf(IPersonInfo personInfo) {
        if (personInfo instanceof PersonInfo) {
            return (PersonInfo) personInfo;
        } else {
            return new PersonInfo(personInfo);
        }
    }

    @NotNull
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) throws OperationNotSupportedException {
        this.name = name;
    }

    public String getPassword() {
        return passwd;
    }

    @Nullable
    @Override
    public IPermissionComponent getPermissionParent() {
        return null;
    }

    @NotNull
    @Override
    public IPermissionSet getSelfPermissionSet() {
        return null;
    }
}
