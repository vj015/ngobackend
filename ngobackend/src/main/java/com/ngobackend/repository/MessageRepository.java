package com.ngobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngobackend.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
