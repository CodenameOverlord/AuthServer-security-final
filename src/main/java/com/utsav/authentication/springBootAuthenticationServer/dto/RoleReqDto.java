package com.utsav.authentication.springBootAuthenticationServer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleReqDto {
    List<String> roles;
}
