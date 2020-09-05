package org.nightvoyager.app.services.data;

import org.jetbrains.annotations.NotNull;
import org.nightvoyager.core.data.roler.IPersonInfo;

import javax.naming.OperationNotSupportedException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonInfo implements IPersonInfo {
    @Id
    @Column(name="id")
    private String id;

    @Column(name="permissions")
    private String permissions;

    @Column
    private String name;

    @NotNull
    @Override
    public String getId() {
        return this.id;
    }

    private PersonInfo(IPersonInfo personInfo){
        this(personInfo.getId());
        try {
            this.setName(personInfo.getName());
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
        this.setPermissions(personInfo.getPermissions());
    }
    public PersonInfo(String id){
        this.id = id;
    }
    public static PersonInfo valueOf(IPersonInfo personInfo){
        if(personInfo instanceof  PersonInfo){
            return (PersonInfo) personInfo;
        }else{
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

    @Override
    public void setPermissions(String[] permissions) {
        this.permissions =  String.join(",",permissions);
    }
}
