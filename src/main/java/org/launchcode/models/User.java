package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank(message="User Name cannot be empty")
    @Size(min = 5 , max = 15, message = "Username is between 5 and 15 characters")
    private String username;
    @Email(message="Must be a valid Email ID")
    private String email;
    @NotBlank(message="Password cannot be empty")
    @Size(min = 6, message = "The password is at least 6 characters long")
    private String password;
    @NotNull(message="Password do not match")
    private String verifyPassword;

    public User() {

    }
    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
//        this.verify = verify;
    }
    public void checkPassword(){
        if(password!=null && verifyPassword!=null && !password.equals(verifyPassword)){
            setVerifyPassword(null);
        }
    }
    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }


//    public String getVerify() {
//        return verify;
//    }
//
//    public void setVerify(String verify) {
//        this.verify = verify;
//    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }
}

