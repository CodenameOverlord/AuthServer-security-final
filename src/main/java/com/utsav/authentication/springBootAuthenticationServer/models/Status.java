package com.utsav.authentication.springBootAuthenticationServer.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Status {
    DELETED,
    EXPIRED,
    ACTIVE
}
