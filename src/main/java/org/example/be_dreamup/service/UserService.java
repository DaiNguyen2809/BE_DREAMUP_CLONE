package org.example.be_dreamup.service;

import org.example.be_dreamup.dto.UserDTO;
import org.example.be_dreamup.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO create(UserDTO dto);
    UserResponseDTO update(String username, UserDTO dto);
    void delete(String username);
    List<UserResponseDTO> getAll();
    UserResponseDTO getByUsername(String username);
    void changeStatusActive(String username);
    void changeStatusInactive(String username);
    void changeStatusSuspended(String username);
    void changeStatusBanned(String username);
    void changeStatusLocked(String username);
}
