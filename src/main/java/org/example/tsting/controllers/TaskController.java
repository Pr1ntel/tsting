package org.example.tsting.controllers;

import lombok.AllArgsConstructor;;
import org.example.tsting.dtos.task_dto.TaskRequestDto;
import org.example.tsting.dtos.task_dto.TaskResponseDto;
import org.example.tsting.models.Task;
import org.example.tsting.servises.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/main")
public class TaskController {
    private final TaskService taskService;

    @GetMapping(value = "/all-task")
    public List<TaskResponseDto> getAllTasks() {
        return taskService.getAll();
    }

    @PostMapping(value = "/new-task")
    public void addNewProject(@RequestBody TaskRequestDto taskRequestDto) {
        taskService.addNewTask(taskRequestDto);
    }
    @DeleteMapping(value = "/delete-task/{id}")
    public Task deleteTask(@PathVariable int id) {
        return taskService.deleteTaskById(id);
    }
    @PatchMapping(value = "/update-task/{id}")
    public Task updateProject(@PathVariable int id, @RequestBody TaskRequestDto taskRequestDto) {
        return taskService.updateTaskById(id, taskRequestDto);
    }
}
