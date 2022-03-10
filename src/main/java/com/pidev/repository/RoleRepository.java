package com.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pidev.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
