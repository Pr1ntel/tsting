package org.example.tsting.controllers;

import lombok.AllArgsConstructor;;
import org.example.tsting.dtos.project_dto.ProjectRequestDto;
import org.example.tsting.dtos.task_dto.TaskRequestDto;
import org.example.tsting.dtos.task_dto.TaskResponseDto;
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
}
