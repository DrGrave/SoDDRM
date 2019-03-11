package com.vidnichuk.isogj.api.dto.model;

import com.vidnichuk.isogj.api.model.Role;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public class UserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
