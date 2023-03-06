package com.ngobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngobackend.entities.Intern;

public interface InternRepository extends JpaRepository<Intern, Integer> {

}
