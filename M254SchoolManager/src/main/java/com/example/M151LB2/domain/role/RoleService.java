package com.example.M151LB2.domain.role;

import java.util.List;

public interface RoleService{

    Role findByName(String name);

    void deleteByName(String name);


    void deleteById(String id);

    List<Role> getAllRoles();

    Role findById(String id);

    Role createRole(Role role);

    String updateRole(String id, Role role) throws Exception;
}
