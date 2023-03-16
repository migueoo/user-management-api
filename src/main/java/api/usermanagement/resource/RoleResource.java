package api.usermanagement.resource;

import api.usermanagement.dto.RoleDto;
import api.usermanagement.dto.RoleUpdateForm;
import api.usermanagement.dto.UserDto;
import api.usermanagement.entity.RoleEntity;
import api.usermanagement.repository.RoleRepository;
import api.usermanagement.service.impl.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleResource {

    private final RoleService roleService;

    private final RoleRepository roleRepository;

    public RoleResource(RoleService roleService, RoleRepository roleRepository) {
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody RoleDto roleDto) {
        roleService.save(roleDto);
    }


    @GetMapping
    public List<RoleEntity> list() {
        return roleRepository.findAll();
    }


    @GetMapping("/{roleId}")
    // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public Optional<RoleEntity> findById(@PathVariable Long id) {
        return roleService.findById(id);
    }


    @PutMapping("/{roleId}")
    public UserDto updateById(@RequestBody RoleUpdateForm form, @PathVariable("id") Long id) {
        return roleService.updateById(form, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        roleService.deleteById(id);
    }
}