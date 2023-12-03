package com.utsav.authentication.springBootAuthenticationServer.dto;

import com.utsav.authentication.springBootAuthenticationServer.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserReqDto {
    private String email;
    private String password;
    private String fullName;
    private String dob;
    private List<String> roles;

    public User convertToUser(){
        User user = new User();
        user.setEmail(this.getEmail());
//        user.setPassword(this.getPassword());
        user.setDob(this.getDob());
        return user;
    }


}
