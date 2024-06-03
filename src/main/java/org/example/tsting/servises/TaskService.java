package org.example.tsting.servises;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
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
    private final ProjectRepository projectRepository;

    public List<TaskResponseDto> getAll() {
        return taskRepository.findAll().stream().map(
                task -> TaskResponseDto.builder()
                        .id(task.getId())
                        .taskStageId(task.getTaskStageName().getTaskStageName())
                        .taskTitle(task.getTaskTitle())
                        .taskDescription(task.getTaskDescription())
                        .executorId(task.getExecutorId().getFirstName() + " " + task.getExecutorId().getLastName())
                        .taskDurationTime(task.getTaskDurationTime())
                        .taskDurationTermId(task.getProjectTerm().getProjectTermName())
                        .priorityTypeId(task.getTaskPriorityType().getTaskPriorityTypeName())
                        .projectName(task.getProjectId().getProjectName())
                        .build()
        ).collect(Collectors.toList());
    }

    public void addNewTask(TaskRequestDto taskRequestDto) {
        TaskStageName findStageNameId = taskStageNameRepository.findById(taskRequestDto.getTaskStageId()).get();
        User findUserId = userRepository.findById(taskRequestDto.getExecutorId()).get();
        ProjectTermName findTermNameId = projectTermNameRepository.findById(taskRequestDto.getTaskDurationTermId()).get();
        TaskPriorityType findPriorityTypeId = priorityTypeRepository.findById(taskRequestDto.getPriorityTypeId()).get();
        Project findProjectName = projectRepository.findById(taskRequestDto.getProjectId()).get();

        Task insertNewTask = Task.builder()
                .id(taskRequestDto.getId())
                .taskStageName(findStageNameId)
                .taskTitle(taskRequestDto.getTaskTitle())
                .taskDescription(taskRequestDto.getTaskDescription())
                .executorId(findUserId)
                .taskDurationTime(taskRequestDto.getTaskDurationTime())
                .projectTerm(findTermNameId)
                .taskPriorityType(findPriorityTypeId)
                .projectId(findProjectName)
                .build();
        taskRepository.save(insertNewTask);
    }

    public Task deleteTaskById(int id) {
        return taskRepository.deleteById(id);
    }

    public Task updateTaskById(int id, TaskRequestDto taskRequestDto) {
        Task updateTaskId = taskRepository.findTaskById(id);
        User findUserById = userRepository.findById(taskRequestDto.getExecutorId()).get();
        ProjectTermName findTaskTermName = projectTermNameRepository.findById(taskRequestDto.getTaskDurationTermId()).get();
        TaskPriorityType findTaskPriorityType = priorityTypeRepository.findById(taskRequestDto.getPriorityTypeId()).get();
        Project findProjectById = projectRepository.findById(taskRequestDto.getProjectId()).get();
        TaskStageName findTaskStageName = taskStageNameRepository.findById(taskRequestDto.getTaskStageId()).get();


        if (updateTaskId != null) {
            updateTaskId.setTaskTitle(taskRequestDto.getTaskTitle());
            updateTaskId.setTaskDescription(taskRequestDto.getTaskDescription());
            updateTaskId.setExecutorId(findUserById);
            updateTaskId.setTaskDurationTime(taskRequestDto.getTaskDurationTime());
            updateTaskId.setProjectTerm(findTaskTermName);
            updateTaskId.setTaskPriorityType(findTaskPriorityType);
            updateTaskId.setProjectId(findProjectById);
            updateTaskId.setTaskStageName(findTaskStageName);


            return taskRepository.save(updateTaskId);
        } else {
            System.out.println("не найден id");
        }
        return updateTaskId;
    }
}
