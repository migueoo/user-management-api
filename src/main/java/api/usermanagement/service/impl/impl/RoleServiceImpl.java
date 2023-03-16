package api.usermanagement.service.impl.impl;

import api.usermanagement.dto.RoleDto;
import api.usermanagement.dto.RoleUpdateForm;
import api.usermanagement.dto.UserDto;
import api.usermanagement.entity.RoleEntity;
import api.usermanagement.entity.UserEntity;
import api.usermanagement.exception.BusinessException;
import api.usermanagement.repository.RoleRepository;
import api.usermanagement.service.impl.RoleService;
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

    public void save(RoleDto roleDto) {
        try {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setDescription(roleDto.getDescription().trim());
            roleRepository.save(roleEntity);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(DUPLICATE_USER);
        }
    }

    @Override
    public Optional<RoleEntity> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public ResponseEntity<RoleEntity> updateRole(long id) {
        return null;
    }

    @Override
    public UserDto updateById(RoleUpdateForm form, Long id) {
        return null;
    }


    // Converter ENTITY to DTO
    private RoleDto convertToDto(RoleEntity roleEntity) {
        RoleDto dto = new RoleDto();
        dto.setId(roleEntity.getId());
        dto.setDescription(roleEntity.getDescription());
        return dto;
    }


    public void deleteById(Long id) {
        try {
            if (roleRepository.existsById(id)) {
                roleRepository.deleteById(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(DUPLICATE_USER);
        }
    }
}





