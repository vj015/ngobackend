package com.ngobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngobackend.entities.fundraise;

public interface FundraiseRepository extends JpaRepository<fundraise, Integer> {

}
