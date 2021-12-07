package com.example.service.impl;

import com.example.converter.UserConverter;
import com.example.dto.UserDTO;
import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.repository.RolesRepository;
import com.example.repository.UserRepository;
import com.example.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IUserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
        if (user == null) {
            log.info("User not found");
            throw new UsernameNotFoundException("User not found");
        } else {
            log.info("User: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(), authorities);
    }

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        log.info("Saving new user {} to the database", userEntity.getFullName());
        return userRepository.save(userEntity);
    }

    @Override
    public RoleEntity saveRoles(RoleEntity roleEntity) {
        log.info("Saving new role {} to the database", roleEntity.getName());
        return rolesRepository.save(roleEntity);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("adding role {} to user {} ", roleName, userName);
        UserEntity userEntity = userRepository.findByUserName(userName);
        RoleEntity roleEntity = rolesRepository.findByName(roleName);
        userEntity.getRoles().add(roleEntity);
    }

    @Override
    public UserEntity getUser(String userName) {
        log.info("Fetching user {} ", userName);
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<UserDTO> getUsers() {
        // Only for test, not gonna do this in real lifeeeeeeeeeeee... pls pagging it
        log.info("Fetching all user");
        List<UserDTO> results = new ArrayList<>();
        List<UserEntity> entities = userRepository.findAll();
        for (UserEntity item : entities) {
            UserDTO userDTO = userConverter.toDTO(item);
            results.add(userDTO);
        }
        return results;
    }


}
