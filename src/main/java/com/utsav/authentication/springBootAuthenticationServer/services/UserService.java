package com.utsav.authentication.springBootAuthenticationServer.services;

import com.utsav.authentication.springBootAuthenticationServer.dto.SuccessResponse;
import com.utsav.authentication.springBootAuthenticationServer.dto.UserReqDto;
import com.utsav.authentication.springBootAuthenticationServer.dto.UserResDto;

import java.util.Optional;

public interface UserService {

    Optional<UserResDto> createUser(UserReqDto userReqDto);

    Optional<SuccessResponse> inactivateUser(Long userId);

    Optional<UserResDto> getUser(Long userId);
}
