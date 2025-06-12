package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.model.LivroModel;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long> {
    
}
