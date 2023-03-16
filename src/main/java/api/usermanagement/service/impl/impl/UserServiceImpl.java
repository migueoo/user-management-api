package api.usermanagement.service.impl.impl;

import api.usermanagement.dto.UserDto;
import api.usermanagement.dto.UserUpdateForm;
import api.usermanagement.entity.UserEntity;
import api.usermanagement.exception.BusinessException;
import api.usermanagement.repository.UserRepository;
import api.usermanagement.service.impl.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import static api.usermanagement.util.ConstantUtils.DUPLICATE_USER;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void createUser(UserDto userDto) {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(userDto.getEmail().trim());
            userEntity.setPassword(userDto.getPassword().trim());
            userRepository.save(userEntity);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(DUPLICATE_USER);
        }
    }

    @Override
    public Optional<UserEntity> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public ResponseEntity<UserEntity> updateUser(long id) {
        return null;
    }

    @Override
    public UserDto updateByUserId(UserUpdateForm form, Long id) {

        Optional<UserEntity> op = userRepository.findById(id);
        if (op.isPresent()) {
            UserEntity obj = op.get();
            if (form.getPassword() != null) {
                obj.setEmail(form.getEmail());
            }
            if (form.getEmail() != null) {
                obj.setPassword(form.getPassword());
            }
            userRepository.save(obj);
            return convertToDto(obj);
        }
        return null;
    }

    // Converter ENTITY to DTO
    private UserDto convertToDto(UserEntity userEntity) {
        UserDto dto = new UserDto();
        dto.setId(userEntity.getId());
        dto.setEmail(userEntity.getEmail());
        dto.setPassword(userEntity.getPassword());
        return dto;
    }


    
    public void deleteById(Long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(DUPLICATE_USER);
        }
    }

}





