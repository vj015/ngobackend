package com.ngobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngobackend.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
