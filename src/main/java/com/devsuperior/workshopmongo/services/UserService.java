package com.devsuperior.workshopmongo.services;

import com.devsuperior.workshopmongo.models.dto.UserDTO;
import com.devsuperior.workshopmongo.models.entities.User;
import com.devsuperior.workshopmongo.repositories.UserRepository;
import com.devsuperior.workshopmongo.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public UserDTO findById(String id){
        User entity = getEntityById(id);
        return new UserDTO(entity);
    }

    private User getEntityById(String id){
        Optional<User> result = repository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
    }

    public UserDTO insert (UserDTO dto){
        User entity = new User();
        copyDtoToEntity(dto, entity);
        entity = repository.insert(entity);
        return new UserDTO(entity);
    }

    public UserDTO update(String id, UserDTO dto){
        User entity = getEntityById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new UserDTO(entity);
    }

    public void delete(String id){
        getEntityById(id);
        repository.deleteById(id);
    }

    private void copyDtoToEntity(UserDTO dto, User entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
    }
}
