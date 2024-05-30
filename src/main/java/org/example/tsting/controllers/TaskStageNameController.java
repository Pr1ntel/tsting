package org.example.tsting.controllers;

import lombok.AllArgsConstructor;
import org.example.tsting.dtos.project_term_name_dto.ProjectTermNameResponseDto;
import org.example.tsting.dtos.task_stage_type_dto.TaskStageTypeResponseDto;
import org.example.tsting.servises.ProjectTermNameService;
import org.example.tsting.servises.TaskStageNameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/main-task-stage-name")
public class TaskStageNameController {
    private final TaskStageNameService taskStageNameService;

    @GetMapping(value = "/all-stage-name")
    public List<TaskStageTypeResponseDto> getAllTermNames() {
        return taskStageNameService.getAllStageNames();
    }
}
