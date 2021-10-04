package com.example.masterwork.services;

import com.example.masterwork.entities.User;
import com.example.masterwork.exceptions.ResourceNotFoundException;
import com.example.masterwork.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    final
    UserRepository repository;


    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        repository.save(user);
        return user;
    }

    @Override
    public List<User> allData() {
        return repository.findAll();
    }

    @Override
    public User findById(long id) {

        Optional<User> byId = repository.findById(id);
        if(byId.isPresent()) {
            return byId.get();
        }else throw new ResourceNotFoundException("Invalid user ID");
    }

    @Override
    public User update(User user, long id) {
        Optional<User> byId = repository.findById(id);
        if(byId.isPresent()){
            return save(user);
        } else throw new  ResourceNotFoundException("Invalid User ID");
    }

    @Override
    public void deleteById(long id) {
        Optional<User> byId = repository.findById(id);
        if(byId.isPresent()){
            repository.deleteById(id);
        } else throw new  ResourceNotFoundException("Invalid User ID");
    }
}
