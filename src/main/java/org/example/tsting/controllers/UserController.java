package org.example.tsting.controllers;

import lombok.AllArgsConstructor;
import org.example.tsting.dtos.project_dto.ProjectResponseDto;
import org.example.tsting.dtos.user_dto.UserResponseDto;
import org.example.tsting.servises.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/main")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/all-users")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAll();
    }

}
