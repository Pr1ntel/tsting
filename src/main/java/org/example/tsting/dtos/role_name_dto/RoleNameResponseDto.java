package org.example.tsting.dtos.role_name_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleNameResponseDto {
    private int id;
    private String name;
}
