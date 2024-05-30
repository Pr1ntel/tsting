package org.example.tsting.servises;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.tsting.dtos.project_stage_name_dto.ProjectStageNameResponseDto;
import org.example.tsting.dtos.task_stage_type_dto.TaskStageTypeResponseDto;
import org.example.tsting.repositorys.ProjectStageNameRepository;
import org.example.tsting.repositorys.TaskStageNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TaskStageNameService {
    private final TaskStageNameRepository taskStageNameRepository;

    public List<TaskStageTypeResponseDto> getAllStageNames() {
        return taskStageNameRepository.findAll().stream().map(
                stageName -> TaskStageTypeResponseDto.builder()
                        .id(stageName.getId())
                        .name(stageName.getTaskStageName())
                        .build()
        ).collect(Collectors.toList());
    }
}
