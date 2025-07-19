package com.sprintcorp.ecommerce_api.mappers;

import com.sprintcorp.ecommerce_api.dtos.UserResponseDTO;
import com.sprintcorp.ecommerce_api.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO userDTO(User user);
}
