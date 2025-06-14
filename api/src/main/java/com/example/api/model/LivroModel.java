package com.example.api.model;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity(name = "livro")
@EntityListeners(AuditingEntityListener.class)
public class LivroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bibliotecario", referencedColumnName = "id", updatable = false)
    private BibliotecarioModel bibliotecario;

    @NotBlank
    @Size(max = 255)
    private String autor;

    @NotBlank
    @Size(max = 255)
    private String titulo;

    @NotBlank
    @Size(max = 255)
    private String genero;

    @Size(max = 255)
    private String status;

    @CreatedDate
    @Column(updatable = false)
    private LocalDate created_date;
}
