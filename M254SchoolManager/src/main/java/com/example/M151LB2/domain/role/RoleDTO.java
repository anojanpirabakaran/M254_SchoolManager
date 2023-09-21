package com.example.M151LB2.domain.role;

import com.example.M151LB2.config.generic.ExtendedDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoleDTO extends ExtendedDTO {

    @NotNull
    @Size(min = 1, max = 25)
    private String name;

    public String getName() {
        return name;
    }

    public RoleDTO setName(String name) {
        this.name = name;
        return this;
    }
}
