package api.usermanagement.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;


    public RoleEntity(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public RoleEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setRoleId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String email) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
