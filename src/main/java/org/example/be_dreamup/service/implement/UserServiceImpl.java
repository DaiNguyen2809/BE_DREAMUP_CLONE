package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.config.UserStatus;
import org.example.be_dreamup.dto.UserDTO;
import org.example.be_dreamup.dto.UserResponseDTO;
import org.example.be_dreamup.mapper.UserMapper;
import org.example.be_dreamup.model.Role;
import org.example.be_dreamup.model.User;
import org.example.be_dreamup.repository.RoleRepository;
import org.example.be_dreamup.repository.UserRepository;
import org.example.be_dreamup.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public UserResponseDTO create (UserDTO dto) {
        Set<Role> roles = new HashSet<>(roleRepository.findAllById(dto.getRoleIds()));
        User entity = mapper.toEntity(dto, roles);
        User saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public UserResponseDTO update (String username, UserDTO dto) {
        Set<Role> roles = new HashSet<>(roleRepository.findAllById(dto.getRoleIds()));
        User entity = repository.findByUsername(username);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Người dùng không tồn tại!");
        }
        mapper.updateEntityFromDTO(dto, entity, roles);
        User updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete(String username) {
        User entity = repository.findByUsername(username);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Người dùng không tồn tại!");
        }
        entity.setDeleted(true);
        entity.setStatus(UserStatus.DELETED);
        repository.save(entity);
    }

    @Override
    public List<UserResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getByUsername(String username) {
        User entity = repository.findByUsername(username);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Người dùng không tồn tại!");
        }
        return mapper.toResponseDTO(entity);
    }

    @Override
    @Transactional
    public void changeStatusActive(String username) {
        User entity = repository.findByUsername(username);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Người dùng không tồn tại!");
        }
        entity.setStatus(UserStatus.ACTIVE);
    }

    @Override
    @Transactional
    public void changeStatusInactive(String username) {
        User entity = repository.findByUsername(username);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Người dùng không tồn tại!");
        }
        entity.setStatus(UserStatus.INACTIVE);
    }

    @Override
    @Transactional
    public void changeStatusBanned(String username) {
        User entity = repository.findByUsername(username);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Người dùng không tồn tại!");
        }
        entity.setStatus(UserStatus.BANNED);
    }

    @Override
    @Transactional
    public void changeStatusSuspended(String username) {
        User entity = repository.findByUsername(username);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Người dùng không tồn tại!");
        }
        entity.setStatus(UserStatus.SUSPENDED);
    }

    @Override
    @Transactional
    public void changeStatusLocked(String username) {
        User entity = repository.findByUsername(username);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Người dùng không tồn tại!");
        }
        entity.setStatus(UserStatus.LOCKED);
    }
}
