package com.example.service;

import com.example.dto.UserDTO;
import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;

import java.util.List;

public interface IUserService {
    UserEntity saveUser(UserEntity userEntity);
    RoleEntity saveRoles(RoleEntity roleEntity);
    void addRoleToUser(String userName, String roleName);
    UserEntity getUser(String userName);
    List<UserDTO> getUsers();
}
