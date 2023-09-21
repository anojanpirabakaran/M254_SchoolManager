package com.example.M151LB2.domain.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(String name);

    void deleteByName(String name);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete from public.users_role where users_id = ?")
    void deleteRelationsToUsersById(String id);

    boolean existsByName(String name);
}
