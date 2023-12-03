package com.utsav.authentication.springBootAuthenticationServer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SuccessResponse {
    String message;
}
