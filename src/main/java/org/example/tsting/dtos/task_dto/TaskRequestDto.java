package org.example.tsting.dtos.task_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDto {
    private int id;
    private int taskStageId;
    private String taskTitle;
    private String taskDescription;
    private int executorId;
    private int taskDurationTime;
    private int taskDurationTermId;
    private int priorityTypeId;
}
