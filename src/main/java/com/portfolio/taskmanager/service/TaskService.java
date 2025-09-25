package com.portfolio.taskmanager.service;

import com.portfolio.taskmanager.model.Task;
import com.portfolio.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //classe de serviço
public class TaskService {

    @Autowired // Injeção de dependência do nosso repositório
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> updateTask(Long id, Task taskDetails) {
        // Busca a tarefa pelo ID
        return taskRepository.findById(id).map(task -> {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setCompleted(taskDetails.isCompleted());
            return taskRepository.save(task); // Salva e retorna a tarefa atualizada
        });
    }

    public boolean deleteTask(Long id) {
        return taskRepository.findById(id).map(task -> {
            taskRepository.delete(task);
            return true; // Retorna true se a tarefa foi encontrada e deletada
        }).orElse(false); // Retorna false se a tarefa não foi encontrada
    }
}
