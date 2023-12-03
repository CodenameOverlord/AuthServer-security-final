package com.utsav.authentication.springBootAuthenticationServer.dto;

import com.utsav.authentication.springBootAuthenticationServer.models.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponseDto {
    UserResDto userResDto;
    SessionStatus sessionStatus;
}
