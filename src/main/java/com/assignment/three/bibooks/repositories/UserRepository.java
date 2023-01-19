package com.assignment.three.bibooks.repositories;


import com.assignment.three.bibooks.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
