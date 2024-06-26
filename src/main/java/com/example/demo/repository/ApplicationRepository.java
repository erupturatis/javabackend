package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

     public Application findByName(String name);
}
