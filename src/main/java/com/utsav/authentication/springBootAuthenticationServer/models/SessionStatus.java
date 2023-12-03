package com.utsav.authentication.springBootAuthenticationServer.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum SessionStatus {
    ACTIVE,
    EXPIRED,
    DELETED,
    INVALID
}
