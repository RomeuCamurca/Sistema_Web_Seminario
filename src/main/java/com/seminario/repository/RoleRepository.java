package com.seminario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seminario.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

}
