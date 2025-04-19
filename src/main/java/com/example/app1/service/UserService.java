package com.example.app1.service;

import com.example.app1.dto.UserDto;

public interface UserService {
    String createUser(UserDto userDto);
    UserDto getUser(Long id);
    String updateUser(Long id, UserDto userDto);
    String deleteUser(Long id);
}
