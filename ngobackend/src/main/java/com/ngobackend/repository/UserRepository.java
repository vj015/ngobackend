package com.ngobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngobackend.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
