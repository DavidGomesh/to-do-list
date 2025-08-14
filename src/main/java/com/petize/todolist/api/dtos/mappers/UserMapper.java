package com.petize.todolist.api.dtos.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.petize.todolist.api.dtos.request.UserRequest;
import com.petize.todolist.api.dtos.response.UserResponse;
import com.petize.todolist.domain.models.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequest dto);

    UserResponse toResponse(User entity);
    List<UserResponse> toResponseList(List<User> entities);
}
