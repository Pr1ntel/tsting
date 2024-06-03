package org.example.tsting.servises;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.tsting.dtos.project_dto.ProjectRequestDto;
import org.example.tsting.dtos.project_dto.ProjectResponseDto;
import org.example.tsting.models.Project;
import org.example.tsting.models.ProjectStageName;
import org.example.tsting.models.ProjectTermName;
import org.example.tsting.repositorys.ProjectRepository;
import org.example.tsting.repositorys.ProjectStageNameRepository;
import org.example.tsting.repositorys.ProjectTermNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectStageNameRepository projectStageNameRepository;
    private final ProjectTermNameRepository projectTermNameRepository;

    public List<ProjectResponseDto> getAll() {
        return projectRepository.findAll().stream().map(
                projects -> ProjectResponseDto.builder()
                        .id(projects.getId())
                        .projectName(projects.getProjectName())
                        .projectDescription(projects.getProjectDescription())
                        .projectTask(projects.getProjectTask())
                        .projectStageId(projects.getProjectStage().getProjectStageName())
                        .projectDurationTime(projects.getProjectDurationTime())
                        .projectDurationTermId(projects.getProjectTerm().getProjectTermName())
                        .build()
        ).collect(Collectors.toList());
    }

    public void addNewProject(ProjectRequestDto projectRequestDto) {
        ProjectTermName findProjectTermName = projectTermNameRepository.findById(projectRequestDto.getProjectDurationTermId()).get();
        ProjectStageName findProjectStageName = projectStageNameRepository.findById(projectRequestDto.getProjectStageId()).get();

        Project insertNewProject = Project.builder()
                .id(projectRequestDto.getId())
                .projectName(projectRequestDto.getProjectName())
                .projectDescription(projectRequestDto.getProjectDescription())
                .projectTask(projectRequestDto.getProjectTask())
                .projectStage(findProjectStageName)
                .projectDurationTime(projectRequestDto.getProjectDurationTime())
                .projectTerm(findProjectTermName)
                .build();
        projectRepository.save(insertNewProject);
    }
    public Project deleteProjectById(int id) {
        return projectRepository.deleteById(id);
    }
}
