package org.example.tsting.dtos.task_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDto {
    private int id;
    private String taskStageId;
    private String taskTitle;
    private String taskDescription;
    private String executorId;
    private int taskDurationTime;
    private String taskDurationTermId;
    private String priorityTypeId;
    private String projectName;
}
