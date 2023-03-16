package api.usermanagement.resource;

import api.usermanagement.dto.UserDto;
import api.usermanagement.dto.UserUpdateForm;
import api.usermanagement.entity.UserEntity;
import api.usermanagement.repository.UserRepository;
import api.usermanagement.service.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    private final UserService userService;

    private final UserRepository userRepository;

    public UserResource(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    // Criando um verbo http post
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
    }


    @GetMapping
    public List<UserEntity> list() {
        return userRepository.findAll();
    }


    @GetMapping("/{id}")
   // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public Optional<UserEntity> findById(@PathVariable Long id) {
        return userService.findUserById(id);
    }


    @PutMapping("/{id}")
    public UserDto updateById(@RequestBody UserUpdateForm form, @PathVariable("id") Long id) {
        return userService.updateByUserId(form, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }


}
