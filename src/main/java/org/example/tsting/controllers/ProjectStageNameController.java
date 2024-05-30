package org.example.tsting.controllers;

import lombok.AllArgsConstructor;
import org.example.tsting.dtos.project_stage_name_dto.ProjectStageNameResponseDto;
import org.example.tsting.repositorys.ProjectStageNameRepository;
import org.example.tsting.servises.ProjectStageNameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/main-project-stage-name")
public class ProjectStageNameController {
    private final ProjectStageNameService projectStageNameService;

    @GetMapping(value = "/all-stage-name")
    public List<ProjectStageNameResponseDto> getAllStageNames() {
        return projectStageNameService.getAllProjectStageNames();
    }
}
