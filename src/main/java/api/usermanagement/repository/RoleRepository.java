package api.usermanagement.repository;

import api.usermanagement.entity.RoleEntity;
import api.usermanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    UserEntity findByDescription(String description);

}
