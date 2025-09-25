package com.portfolio.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity // Marca esta classe como uma entidade JPA (tabela no banco de dados)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automaticamente
    private Long id;

    @NotBlank(message = "O título é obrigatório") // Validação: não pode ser nulo ou vazio
    @Size(min = 3, message = "O título deve ter no mínimo 3 caracteres")
    @Column(nullable = false) // Mapeamento da coluna no banco
    private String title;

    @Column(length = 1000) // Define um tamanho maior para a descrição
    private String description;

    @Column(nullable = false)
    private boolean completed = false; // Valor padrão é 'false'

    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
