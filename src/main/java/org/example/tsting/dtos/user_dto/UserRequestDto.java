package org.example.tsting.dtos.user_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private int roleName;
}
