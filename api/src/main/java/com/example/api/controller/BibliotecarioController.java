package com.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.BibliotecarioModel;
import com.example.api.repository.BibliotecarioRepository;

// import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bibliotecarios")
@CrossOrigin("*")
public class BibliotecarioController extends AbstractController<BibliotecarioModel, Long> {
    public BibliotecarioController(@Autowired BibliotecarioRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<BibliotecarioModel> update(Long id, BibliotecarioModel updated) {
        return repository.findById(id)
                .map(bibliotecario -> {
                    if (updated.getNome() != null) {
                        bibliotecario.setNome(updated.getNome());
                    }

                    if (updated.getEmail() != null) {
                        bibliotecario.setEmail(updated.getEmail());
                    }
                    
                    return ResponseEntity.ok(repository.save(bibliotecario));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
