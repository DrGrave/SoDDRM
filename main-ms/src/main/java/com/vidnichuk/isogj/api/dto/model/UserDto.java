package com.vidnichuk.isogj.api.dto.model;

import java.util.Date;

/**
 * User dto object
 */
public class UserDto {
    /**
     * user id
     */
    private String uid;

    /**
     * user name
     */
    private String firstName;
    /**
     * user surname
     */
    private String lastName;
    /**
     * user patronymic
     */
    private String middleName;

    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

}
