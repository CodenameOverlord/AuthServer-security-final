package com.utsav.authentication.springBootAuthenticationServer.controllers;

import com.utsav.authentication.springBootAuthenticationServer.dto.FailureResponse;
import com.utsav.authentication.springBootAuthenticationServer.dto.SuccessResponse;
import com.utsav.authentication.springBootAuthenticationServer.dto.UserReqDto;
import com.utsav.authentication.springBootAuthenticationServer.dto.UserResDto;
import com.utsav.authentication.springBootAuthenticationServer.services.UserService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService userService;
    @PostMapping( "/user")
    public ResponseEntity<?> createUser(@RequestBody UserReqDto userReqDto){
        Optional<UserResDto> userResDtoOptional = userService.createUser(userReqDto);
        if(userResDtoOptional.isPresent()){
            return new ResponseEntity<>(userResDtoOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping( "/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId){
        Optional<UserResDto> userResDtoOptional = userService.getUser(userId);
        if(userResDtoOptional.isPresent()){
            return new ResponseEntity<>(userResDtoOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping( "user/inactivate/{userId}")
    public ResponseEntity<?> inactivateUser(@PathVariable(name = "userId") Long userId){
        Optional<SuccessResponse> userResDtoOptional = userService.inactivateUser(userId);
        if(userResDtoOptional.isPresent()){
            return new ResponseEntity<>(userResDtoOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
