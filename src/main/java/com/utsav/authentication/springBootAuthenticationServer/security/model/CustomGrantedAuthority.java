package com.utsav.authentication.springBootAuthenticationServer.security.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.utsav.authentication.springBootAuthenticationServer.models.Role;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@JsonDeserialize
@NoArgsConstructor
public class CustomGrantedAuthority implements GrantedAuthority {
    private Role role;
    private String authority;

    public CustomGrantedAuthority(Role role){
        this.role =role;
        this.authority = role.getRole();
    }
    @Override
    public String getAuthority() {
        return this.authority;
    }
}
