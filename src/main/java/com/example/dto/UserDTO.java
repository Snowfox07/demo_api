package com.example.dto;

import com.example.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserDTO extends BaseDTO<UserDTO>{
    private String userName;
    private String fullName;
    private String status;
    private List<RoleDTO> roles;


}
