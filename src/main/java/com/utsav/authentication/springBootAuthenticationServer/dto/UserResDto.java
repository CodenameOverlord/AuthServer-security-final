package com.utsav.authentication.springBootAuthenticationServer.dto;

import com.utsav.authentication.springBootAuthenticationServer.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserResDto {
    private String email;
    private String fullName;
    private Long id;
    private List<String> roles;

    public UserResDto(User user) {
        this.email = user.getEmail();
        this.id = user.getId();
        this.fullName = user.getFullName();
        if(user.getRoles()!=null)
        this.roles = user.getRoles().stream().map(t->t.getRole()).collect(Collectors.toList());
    }
}
