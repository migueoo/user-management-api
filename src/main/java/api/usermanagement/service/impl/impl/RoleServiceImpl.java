package api.usermanagement.service.impl.impl;

import api.usermanagement.dto.RoleDto;
import api.usermanagement.dto.RoleUpdateForm;
import api.usermanagement.dto.UserDto;
import api.usermanagement.dto.UserUpdateForm;
import api.usermanagement.entity.RoleEntity;
import api.usermanagement.entity.UserEntity;
import api.usermanagement.exception.BusinessException;
import api.usermanagement.repository.RoleRepository;
import api.usermanagement.repository.UserRepository;
import api.usermanagement.service.impl.RoleService;
import api.usermanagement.service.impl.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static api.usermanagement.util.ConstantUtils.DUPLICATE_USER;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void saveRole(RoleDto roleDto) {
        try {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setDescription(roleDto.getDescription().trim());
            roleRepository.save(roleEntity);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(DUPLICATE_USER);
        }
    }

    @Override
    public Optional<RoleEntity> findByRoleId(Long roleId) {
        return roleRepository.findByRoleId(roleId);
    }

    @Override
    public ResponseEntity<RoleEntity> updateRole(long roleId) {
        return null;
    }

    @Override
    public UserDto updateByRoleId(RoleUpdateForm form, Long roleId) {

        Optional<UserEntity> op = roleRepository.findByRoleId(roleId);
        if (op.isPresent()) {
            UserEntity obj = op.get();
            if (form.getPassword() != null) {
                obj.setEmail(form.getEmail());
            }
            if (form.getEmail() != null) {
                obj.setPassword(form.getPassword());
            }
            roleRepository.save(obj);
            return convertToDto(obj);
        }
        return null;
    }

    // Converter ENTITY to DTO
    private RoleDto RoleConvertToDto(RoleEntity roleEntity) {
        RoleDto dto = new RoleDto();
        dto.setRoleId(roleEntity.getRoleId());
        dto.setDescription(roleEntity.getDescription());
        return dto;
    }


    public void deleteByRoleId(Long roleId) {
        try {
            if (roleRepository.existsByRoleId(roleId)) {
                roleRepository.deleteByRoleId(roleId);
            }
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(DUPLICATE_USER);
        }
    }

}





