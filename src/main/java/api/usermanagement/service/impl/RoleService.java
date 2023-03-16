package api.usermanagement.service.impl;

import api.usermanagement.dto.RoleDto;
import api.usermanagement.dto.RoleUpdateForm;
import api.usermanagement.dto.UserDto;
import api.usermanagement.dto.UserUpdateForm;
import api.usermanagement.entity.RoleEntity;
import api.usermanagement.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface RoleService {
    void save(RoleDto roleDto);

    Optional<RoleEntity> findById(Long id);

    ResponseEntity<RoleEntity> updateRole(long id);

    UserDto updateById(RoleUpdateForm form, Long roleId);

    void deleteById(Long id);

}
