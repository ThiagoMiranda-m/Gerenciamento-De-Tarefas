package com.portfolio.taskmanager.controller;

import com.portfolio.taskmanager.model.Task;
import com.portfolio.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Combina @Controller e @ResponseBody, simplificando a criação de APIs REST
@RequestMapping("/api/tasks") // Define o caminho base para todos os endpoints deste controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    // GET /api/tasks - Listar todas as tarefas
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // GET /api/tasks/{id} - Buscar uma tarefa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok) // Se encontrar, retorna 200 OK com a tarefa
                .orElse(ResponseEntity.notFound().build()); // Se não, retorna 404 Not Found
    }

    // POST /api/tasks - Criar uma nova tarefa
    @PostMapping
    public Task createTask(@Valid @RequestBody Task task) {
        // @Valid ativa a validação que definimos no model
        // @RequestBody converte o JSON do corpo da requisição para um objeto Task
        return taskService.createTask(task);
    }

    // PUT /api/tasks/{id} - Atualizar uma tarefa existente
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/tasks/{id} - Deletar uma tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.deleteTask(id)) {
            return ResponseEntity.noContent().build(); // Retorna 204 No Content em caso de sucesso
        }
        return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar a tarefa
    }
}
