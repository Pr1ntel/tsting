package org.example.tsting.servises;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.tsting.dtos.task_priority_dto.TaskPriorityResponseDto;
import org.example.tsting.dtos.task_stage_type_dto.TaskStageTypeResponseDto;
import org.example.tsting.repositorys.TaskPriorityTypeRepository;
import org.example.tsting.repositorys.TaskStageNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TaskPriorityService {
    private final TaskPriorityTypeRepository taskPriorityTypeRepository;

    public List<TaskPriorityResponseDto> getAllPriorityTypeNames() {
        return taskPriorityTypeRepository.findAll().stream().map(
                priorityType -> TaskPriorityResponseDto.builder()
                        .id(priorityType.getId())
                        .name(priorityType.getTaskPriorityTypeName())
                        .build()
        ).collect(Collectors.toList());
    }
}
