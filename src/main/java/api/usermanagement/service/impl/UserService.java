package api.usermanagement.service.impl;

import api.usermanagement.dto.UserDto;
import api.usermanagement.dto.UserUpdateForm;
import api.usermanagement.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    void createUser(UserDto userDto);

    Optional<UserEntity> findUserById(Long id);

    ResponseEntity<UserEntity> updateUser(long id);

    UserDto updateByUserId(UserUpdateForm form, Long id);

    void deleteById(Long id);
}
