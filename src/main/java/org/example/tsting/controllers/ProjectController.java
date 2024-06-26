package org.example.tsting.controllers;

import lombok.AllArgsConstructor;
import org.example.tsting.dtos.project_dto.ProjectRequestDto;
import org.example.tsting.dtos.project_dto.ProjectResponseDto;
import org.example.tsting.models.Project;
import org.example.tsting.servises.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/main")
public class ProjectController {
    private final ProjectService projectService;


    @GetMapping(value = "/all-projects")
    public List<ProjectResponseDto> getAllProjects() {
        return projectService.getAll();
    }

    @PostMapping(value = "/new-project")
    public void addNewProject(@RequestBody ProjectRequestDto projectRequestDto) {
        projectService.addNewProject(projectRequestDto);
    }
    @DeleteMapping(value = "/delete-project/{id}")
    public Project projectDelete(@PathVariable int id) {
        return projectService.deleteProjectById(id);
    }
    @PatchMapping(value = "/update-project/{id}")
    public Project updateProject(@PathVariable int id, @RequestBody ProjectRequestDto projectRequestDto) {
        return projectService.updateProjectById(id, projectRequestDto);
    }
}
