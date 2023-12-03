package com.utsav.authentication.springBootAuthenticationServer.security.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.utsav.authentication.springBootAuthenticationServer.models.User;
import com.utsav.authentication.springBootAuthenticationServer.security.services.CustomUserDetailService;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@JsonDeserialize
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {
    User user;
    private List<CustomGrantedAuthority> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enabled;
    private boolean credentialsNonExpired;
    private Long userId;
    public Long getUserId(){
        return this.userId;
    }
    public CustomUserDetails(User user){
        this.user = user;
        this.userId = user.getId();
        List<CustomGrantedAuthority> customGrantedAuthorities  = new ArrayList<>();
        if(user.getRoles()!=null)
            customGrantedAuthorities =
                    this.user.getRoles().
                            stream().
                            map(t->new CustomGrantedAuthority(t)).
                            collect(Collectors.toList());
        this.authorities = customGrantedAuthorities;
        this.password = user.getPassword();
        this.username= user.getEmail();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled= true;

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
