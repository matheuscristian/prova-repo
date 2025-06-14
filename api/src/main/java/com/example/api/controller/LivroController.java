package com.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.LivroModel;
import com.example.api.repository.LivroRepository;

// import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin("*")
public class LivroController extends AbstractController<LivroModel, Long> {
    public LivroController(@Autowired LivroRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<LivroModel> update(Long id, LivroModel updated) {
        return repository.findById(id)
                .map(livro -> {
                    if (updated.getAutor() != null) {
                        livro.setAutor(updated.getAutor());
                    }

                    if (updated.getTitulo() != null) {
                        livro.setTitulo(updated.getTitulo());
                    }

                    if (updated.getGenero() != null) {
                        livro.setGenero(updated.getGenero());
                    }

                    if (updated.getStatus() != null) {
                        livro.setStatus(updated.getStatus());
                    }

                    if (updated.getBibliotecario() != null) {
                        livro.getBibliotecario().setId(updated.getBibliotecario().getId());
                    }

                    return ResponseEntity.ok(repository.save(livro));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
