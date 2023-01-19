package com.assignment.three.bibooks.services;


import com.assignment.three.bibooks.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List<User> getUsers();

    User getUserById(Long id);

    User insert(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long userId);
}
