package com.example.exportlabor.model;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long userId;
    @NotBlank(message = "Username can not be blank")
    private String username;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    @NotBlank(message = "Password can't be blank")
    private String password;
    @Email(message = "Invalid email address")
    @Column(unique = true)
    @NotBlank(message = "Email can't be blank")
    private String email;
    @NotBlank(message = "Name can not be blank")
    private String name;


//    public void setPassword(String password) {
//        String username = getUsername();
//        for (int i = 0; i < username.length(); i++) {
//            if (i + 2 > username.length()) {
//                break;
//            }
//            String contain = username.substring(i, i + 2);
//            if (password.contains(contain)) {
//                throw new RuntimeException("Password should not contain username");
//            }
//        }
//        this.password = password;
//
//    }

}
