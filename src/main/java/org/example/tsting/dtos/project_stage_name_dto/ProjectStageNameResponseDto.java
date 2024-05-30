package org.example.tsting.dtos.project_stage_name_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectStageNameResponseDto {
    private int id;
    private String name;
}
