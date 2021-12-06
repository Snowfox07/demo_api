package com.example.converter;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    private final ModelMapper mapper;

    public UserConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public UserEntity toEntity(UserDTO dto){
        UserEntity userEntity = mapper.map(dto, UserEntity.class);
        return userEntity;
    }

    public  UserDTO toDTO(UserEntity entity){
        UserDTO userDTO = mapper.map(entity, UserDTO.class);
        return userDTO;
    }
}
