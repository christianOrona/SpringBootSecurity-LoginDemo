package com.christianorona.SecurityDBDemo.repository;

import com.christianorona.SecurityDBDemo.model.CustomUserDetails;
import com.christianorona.SecurityDBDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByName(String username);
    User findByNameInIgnoreCase(String username);

    List<User> findAll();
}
