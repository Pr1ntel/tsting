package org.example.tsting.controllers;

import lombok.AllArgsConstructor;
import org.example.tsting.dtos.task_priority_dto.TaskPriorityResponseDto;
import org.example.tsting.dtos.task_stage_type_dto.TaskStageTypeResponseDto;
import org.example.tsting.servises.TaskPriorityService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/main")
public class TaskPriorityTypeController {
    private final TaskPriorityService taskPriorityService;
    @GetMapping(value = "/all-priority-type")
    public List<TaskPriorityResponseDto> getAllPriorityTypes() {
        return taskPriorityService.getAllPriorityTypeNames();
    }
}
