package com.example.exportlabor.model;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long userId;
    @NotBlank(message = "Username can not be blank")
    private String username;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$", message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    private String password;
    @Email(message = "Invalid email address")
    private String email;
    @NotBlank(message = "Name can not be blank")
    private String name;

    public User(Long userId, String username, String password, String email, String name) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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
        String username = getUsername();
        boolean isValid = true;
        for (int i = 0; i < username.length(); i++) {
            if(i+2 > username.length()){
                break;
            }
            String contain = username.substring(i,i+2);
            if(password.contains(contain)){
                isValid = false;
                break;
            }
        }
        if (isValid) this.password = password;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
