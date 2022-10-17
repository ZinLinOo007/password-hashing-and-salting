package com.example.springsecuritymaster.ds;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RegisterUser {

    @NotBlank(message = "User Name cannot be empty.")
    @Pattern(regexp = "[A-Za-z0-9 ]*",message = "User Name cannot contains illegal character.")
    private String userName;

    @NotBlank(message = "Password cannot be empty.")
    @Pattern(regexp = "[A-Za-z0-9]*",message = "Password cannot contains illegal character.")
    private String password;

    @NotBlank(message = "RepeatedPassword cannot be empty.")
    @Pattern(regexp = "[A-Za-z0-9]*",message = "RepeatedPassword cannot contains illegal character.")
    private String repeatedPassword;
}
