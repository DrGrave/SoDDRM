package com.vidnichuk.isogj.api.dto.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.util.Date;

@ApiModel("User registration model")
public class TempUserDto {

    @ApiModelProperty(example = "1234567a", value = "User's password")
    @NotBlank(message = "Provide not blank password")
    @Length(max = 255, message = "Too long password (max 255 characters).")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{8,}$",
            message = "Password should contain at least one digit, one latin character and at least 8 characters.")
    private String password;

    @ApiModelProperty("User's login")
    @NotBlank(message = "Provide not blank login")
    private String username;

    @ApiModelProperty(value = "User's email", example = "email@example.com")
    @Email(message = "Provide correct email.")
    @NotBlank(message = "Provide correct email.")
    private String email;

    @Length(max = 255, message = "First name is too large")
    private String firstName;

    @Length(max = 255, message = "Last name is too large")
    private String lastName;

    @Length(max = 255, message = "Middle name is too large")
    private String middleName;

    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
