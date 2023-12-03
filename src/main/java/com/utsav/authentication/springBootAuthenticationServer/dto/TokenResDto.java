package com.utsav.authentication.springBootAuthenticationServer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResDto {
    private String token;
    private String message;
}
