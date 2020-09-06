package org.nightvoyager.app.entities;

import org.jetbrains.annotations.NotNull;
import org.nightvoyager.core.data.roler.IPersonInfo;
import org.nightvoyager.core.security.Permissions;

import javax.naming.OperationNotSupportedException;
import javax.persistence.*;

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

    private String[] getPermissionsAsArray(){

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
        this.setPermissions(personInfo.getPermissions());
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

    @Override
    public String[] getPermissions() {
        return permissions.split(",");
    }

}
