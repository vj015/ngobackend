package com.ngobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngobackend.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
