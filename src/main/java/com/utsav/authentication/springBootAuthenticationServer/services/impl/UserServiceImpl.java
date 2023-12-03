package com.utsav.authentication.springBootAuthenticationServer.services.impl;

import com.utsav.authentication.springBootAuthenticationServer.dto.SuccessResponse;
import com.utsav.authentication.springBootAuthenticationServer.dto.UserReqDto;
import com.utsav.authentication.springBootAuthenticationServer.dto.UserResDto;
import com.utsav.authentication.springBootAuthenticationServer.models.Role;
import com.utsav.authentication.springBootAuthenticationServer.models.Status;
import com.utsav.authentication.springBootAuthenticationServer.models.User;
import com.utsav.authentication.springBootAuthenticationServer.models.UserStatus;
import com.utsav.authentication.springBootAuthenticationServer.repositories.RoleRepository;
import com.utsav.authentication.springBootAuthenticationServer.repositories.UserRepository;
import com.utsav.authentication.springBootAuthenticationServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public Optional<UserResDto> createUser(UserReqDto userReqDto) {
        if(checkValid(userReqDto)) {
            User user = userReqDto.convertToUser();
            user.setPassword(passwordEncoder.encode(userReqDto.getPassword()));
            user.setStatus(Status.ACTIVE);
            User userSaved = userRepository.save(user);
            if (userReqDto.getRoles() != null && userReqDto.getRoles().size() > 0) {
                List<Role> roles = new ArrayList<>();
                for (String roleStr : userReqDto.getRoles()) {
                    Role role = new Role();
                    role.setStatus(Status.ACTIVE);
                    role.setRole(roleStr);
                    role.setUser(user);
                    roles.add(role);
                    roleRepository.save(role);
                }
                userSaved.setRoles(roles);
                userSaved = userRepository.save(user);
            }
            UserResDto userResDto = new UserResDto(user);
            return Optional.of(userResDto);
        }
        return Optional.empty();
    }

    private boolean checkValid(UserReqDto userReqDto) {
        Optional<User> user= userRepository.findByEmailAndStatus(userReqDto.getEmail(), Status.ACTIVE);
        if(user.isPresent()){
            return false;
        }
        else{
            return true;
        }

    }

//    private UserResDto addRolesToUser(User user, List<String> roleReqStr) {
//        List<String> newRoles = roleReqStr;
////        List<Role> existingRoles = user.getRoles();
//        List<Role> updatedRoles = new ArrayList<>();
//
//        for(String rStr: newRoles){
//            Role r = new Role();
//            r.setRole(rStr);
//            r.setStatus(Status.ACTIVE);
//            r.setUser(user);
//            roleRepository.save(r);
//            updatedRoles.add(r);
//        }
//        user.setRoles(updatedRoles);
//        userRepository.save(user);
//
////
////
//
//
//        UserResDto userResDto = ObjectConverter.convertUserToUserResDto(user);
//        userResDto.setRoles(newRoles);
//        return  userResDto;
//    }

    @Override
    public Optional<SuccessResponse> inactivateUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setStatus(Status.DELETED);
            List<Role> roles = user.getRoles();
            for(Role role:roles){
                role.setStatus(Status.DELETED);
            }
            roleRepository.saveAll(roles);
            userRepository.save(user);
            return Optional.of(SuccessResponse.builder().message("inactivated successfully").build());
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserResDto> getUser(Long userId) {

        return Optional.empty();
    }
}
