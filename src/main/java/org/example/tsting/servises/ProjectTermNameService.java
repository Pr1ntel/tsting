package org.example.tsting.servises;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.tsting.dtos.project_stage_name_dto.ProjectStageNameResponseDto;
import org.example.tsting.dtos.project_term_name_dto.ProjectTermNameResponseDto;
import org.example.tsting.repositorys.ProjectTermNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ProjectTermNameService {
    private final ProjectTermNameRepository projectTermNameRepository;
    public List<ProjectTermNameResponseDto> getAllProjectTermNames() {
        return projectTermNameRepository.findAll().stream().map(
                stageName -> ProjectTermNameResponseDto.builder()
                        .id(stageName.getId())
                        .name(stageName.getProjectTermName())
                        .build()
        ).collect(Collectors.toList());
    }
}
