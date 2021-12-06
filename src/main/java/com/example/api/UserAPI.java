package com.example.api;

import com.example.dto.UserDTO;
import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.service.impl.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAPI {
    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>>getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PutMapping("/user/save")
    public ResponseEntity<UserEntity>saveUser(@RequestBody UserEntity userEntity){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(userEntity));
    }

    @PostMapping("/role/save")
    public ResponseEntity<RoleEntity>saveRole(@RequestBody RoleEntity roleEntity){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRoles(roleEntity));
    }

//    @PostMapping("/role/addtouser")
//    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form){
//        userService.addRoleToUser(form.getUserName(),form.getRoleName());
//        return ResponseEntity.ok().build();
//    }


}

//@Data
//class RoleToUserForm {
//    private String userName;
//    private String roleName;
//
//}