package api.usermanagement.resource;

import api.usermanagement.dto.RoleDto;
import api.usermanagement.dto.RoleUpdateForm;
import api.usermanagement.dto.UserDto;
import api.usermanagement.entity.UserEntity;
import api.usermanagement.repository.RoleRepository;
import api.usermanagement.service.impl.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleResouce {

    private final RoleService roleService;

    private final RoleRepository roleRepository;

    public RoleResouce(RoleService roleService, RoleRepository roleRepository) {
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody RoleDto roleDto) {
        roleService.saveRole(roleDto);
    }


    @GetMapping
    public List<UserEntity> list() {
        return roleRepository.findAll();
    }


    @GetMapping("/{roleId}")
    // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public Optional<UserEntity> findRoleById(@PathVariable Long roleId) {
        return roleService.findRoleById(roleId);
    }


    @PutMapping("/{roleId}")
    public UserDto updateRoleById(@RequestBody RoleUpdateForm form, @PathVariable("roleId") Long roleId) {
        return roleService.updateByRoleId(form, roleId);
    }

    @DeleteMapping("/{roleId}")
    public void deleteRoleById(@PathVariable("roleId") Long id) {
        roleService.deleteRoleById(id);
    }


}