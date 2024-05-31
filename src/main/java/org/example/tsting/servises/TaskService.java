package org.example.tsting.servises;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.tsting.dtos.project_dto.ProjectRequestDto;
import org.example.tsting.dtos.project_dto.ProjectResponseDto;
import org.example.tsting.dtos.task_dto.TaskRequestDto;
import org.example.tsting.dtos.task_dto.TaskResponseDto;
import org.example.tsting.models.*;
import org.example.tsting.repositorys.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskStageNameRepository taskStageNameRepository;
    private final UserRepository userRepository;
    private final ProjectTermNameRepository projectTermNameRepository;
    private final TaskPriorityTypeRepository priorityTypeRepository;

    public List<TaskResponseDto> getAll() {
        return taskRepository.findAll().stream().map(
                task -> TaskResponseDto.builder()
                        .taskStageId(task.getTaskStageName().getTaskStageName())
                        .taskTitle(task.getTaskTitle())
                        .taskDescription(task.getTaskDescription())
                        .executorId(task.getExecutorId().getFirstName() + " " + task.getExecutorId().getLastName())
                        .taskDurationTime(task.getTaskDurationTime())
                        .taskDurationTermId(task.getProjectTerm().getProjectTermName())
                        .priorityTypeId(task.getTaskPriorityType().getTaskPriorityTypeName())
                        .build()
        ).collect(Collectors.toList());
    }

    public void addNewTask(TaskRequestDto taskRequestDto) {
        TaskStageName findStageNameId = taskStageNameRepository.findById(taskRequestDto.getTaskStageId()).get();
        User findUserId = userRepository.findById(taskRequestDto.getExecutorId()).get();
        ProjectTermName findTermNameId = projectTermNameRepository.findById(taskRequestDto.getTaskDurationTermId()).get();
        TaskPriorityType findPriorityTypeId = priorityTypeRepository.findById(taskRequestDto.getPriorityTypeId()).get();

                Task insertNewTask = Task.builder()
                        .taskStageName(findStageNameId)
                        .taskTitle(taskRequestDto.getTaskTitle())
                        .taskDescription(taskRequestDto.getTaskDescription())
                        .executorId(findUserId)
                        .taskDurationTime(taskRequestDto.getTaskDurationTime())
                        .projectTerm(findTermNameId)
                        .taskPriorityType(findPriorityTypeId)
                .build();
        taskRepository.save(insertNewTask);
    }
}
