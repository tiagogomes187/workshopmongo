package com.devsuperior.workshopmongo.services;

import com.devsuperior.workshopmongo.models.dto.UserDTO;
import com.devsuperior.workshopmongo.models.entities.User;
import com.devsuperior.workshopmongo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> findAll() {
        List<User> list = repository.findAll();
        return list.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
