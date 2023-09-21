package com.example.M151LB2.domain.role.mapper;

import com.example.M151LB2.domain.role.Role;
import com.example.M151LB2.domain.role.RoleDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role fromDTO(RoleDTO roleDTO);

    List<Role> fromDTOs(List<RoleDTO> roleDTOS);

    RoleDTO toDTO(Role role);

    List<RoleDTO> toDTOs(List<Role> roles);
}
