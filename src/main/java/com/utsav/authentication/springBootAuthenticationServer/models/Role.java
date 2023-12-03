package com.utsav.authentication.springBootAuthenticationServer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "roles")
@Getter
@Setter
public class Role extends BaseModel {
    private String role;
    @ManyToOne
    private User user;
}
