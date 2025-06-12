package com.example.api.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

public abstract class AbstractController<U, ID> {
    protected final JpaRepository<U, ID> repository;

    public AbstractController(JpaRepository<U, ID> repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<U> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<U> getById(@PathVariable ID id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public U create(@Valid @RequestBody U body) {
        return repository.save(body);
    }

    @PutMapping("/{id}")
    public abstract ResponseEntity<U> update(@PathVariable ID id, @Valid @RequestBody U updated);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        return repository.findById(id)
                .map(cargo -> {
                    repository.delete(cargo);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
