package api.usermanagement.service.impl;

import api.usermanagement.dto.RoleUpdateForm;
import api.usermanagement.dto.UserDto;
import api.usermanagement.dto.UserUpdateForm;
import api.usermanagement.entity.RoleEntity;
import api.usermanagement.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface RoleService {
    void saveRole(RoleService roleDto);

    Optional<RoleEntity> findRoleId(Long id);

    ResponseEntity<RoleEntity> updateRole(long id);

    UserDto updateByRoleId(RoleUpdateForm form, Long roleId);

    void deleteByRoleId(Long id);
}
