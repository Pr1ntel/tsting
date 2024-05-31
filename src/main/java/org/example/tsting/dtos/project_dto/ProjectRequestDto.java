package org.example.tsting.dtos.project_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequestDto {
 private int id;
 private String projectName;
 private String projectTask;
 private String projectDescription;
 private int projectStageId;
 private int projectDurationTime;
 private int projectDurationTermId;
}
