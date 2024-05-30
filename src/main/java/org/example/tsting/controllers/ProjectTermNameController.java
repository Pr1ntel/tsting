package org.example.tsting.controllers;

import lombok.AllArgsConstructor;
import org.example.tsting.dtos.project_stage_name_dto.ProjectStageNameResponseDto;
import org.example.tsting.dtos.project_term_name_dto.ProjectTermNameResponseDto;
import org.example.tsting.repositorys.ProjectTermNameRepository;
import org.example.tsting.servises.ProjectTermNameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/main-project-term-name")
public class ProjectTermNameController {
    private final ProjectTermNameService projectTermNameService;

    @GetMapping(value = "/all-term-name")
    public List<ProjectTermNameResponseDto> getAllTermNames() {
        return projectTermNameService.getAllProjectTermNames();
    }
}
