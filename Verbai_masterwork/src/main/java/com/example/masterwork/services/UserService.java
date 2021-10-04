package com.example.masterwork.services;

import com.example.masterwork.entities.User;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User save(User user);

    List<User> allData();

    User findById(long id);

    User update(User user, long id);

    void deleteById(long id);

}
