package org.example.tsting.dtos.task_stage_type_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskStageTypeResponseDto {
    private int id;
    private String name;
}
