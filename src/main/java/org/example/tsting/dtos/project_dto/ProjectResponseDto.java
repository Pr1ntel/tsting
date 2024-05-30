package org.example.tsting.dtos.project_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDto {
    private String projectName;
    private String projectTask;
    private String projectDescription;
    private String projectStageId;
    private int projectDurationTime;
    private String projectDurationTermId;
}
