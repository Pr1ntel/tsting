package org.example.tsting.servises;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.tsting.dtos.project_stage_name_dto.ProjectStageNameResponseDto;
import org.example.tsting.repositorys.ProjectStageNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ProjectStageNameService {
    private final ProjectStageNameRepository projectStageNameRepository;

    public List<ProjectStageNameResponseDto> getAllProjectStageNames() {
        return projectStageNameRepository.findAll().stream().map(
                stageName -> ProjectStageNameResponseDto.builder()
                        .id(stageName.getId())
                        .name(stageName.getProjectStageName())
                        .build()
        ).collect(Collectors.toList());
    }

}
