package com.utsav.authentication.springBootAuthenticationServer.dto;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FailureResponse {
    private String message;
}
