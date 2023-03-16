package api.usermanagement.dto;

import api.usermanagement.entity.RoleEntity;

public class RoleDto {
    private Long roleId;
    //description = email
    private String description;


    public RoleDto(Long roleId, String description) {
        this.roleId = roleId;
        this.description = description;
    }

    public RoleDto(RoleEntity roleEntity) {
    }

    public RoleDto() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long id) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String email) {
        this.description = description;
    }


}

