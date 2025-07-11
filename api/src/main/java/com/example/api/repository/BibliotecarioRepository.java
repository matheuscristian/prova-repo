package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.model.BibliotecarioModel;

@Repository
public interface BibliotecarioRepository extends JpaRepository<BibliotecarioModel, Long> {
    
}
