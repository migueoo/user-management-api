package api.usermanagement.dto;

import api.usermanagement.entity.RoleEntity;

public class RoleDto {
    private Long Id;
    //description = email
    private String description;


    public RoleDto(Long roleId, String description) {
        this.Id = Id;
        this.description = description;
    }

    public RoleDto(RoleEntity roleEntity) {
    }

    public RoleDto() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

