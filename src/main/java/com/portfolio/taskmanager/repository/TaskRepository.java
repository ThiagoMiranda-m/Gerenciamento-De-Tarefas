package com.portfolio.taskmanager.repository;

import com.portfolio.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que esta é uma classe de repositório gerenciada pelo Spring
public interface TaskRepository extends JpaRepository<Task, Long> {

    // JpaRepository já nos fornece os métodos CRUD (save, findById, findAll, deleteById, etc.)
    // O primeiro parâmetro é a entidade (Task) e o segundo é o tipo da chave primária (Long)

}
