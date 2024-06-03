package org.example.tsting.servises;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.tsting.dtos.user_dto.UserResponseDto;
import org.example.tsting.repositorys.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<UserResponseDto> getAll() {


        return userRepository.findAll().stream().map(
                users -> UserResponseDto.builder()
                        .id(users.getId())
                        .firstName(users.getFirstName())
                        .lastName(users.getLastName())
                        .login(users.getLogin())
                        .roleName(users.getRoleName().getRoleName())
                        .build()
        ).collect(Collectors.toList());
    }

}
