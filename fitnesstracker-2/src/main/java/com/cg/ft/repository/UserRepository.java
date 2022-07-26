package com.cg.ft.repository;


import com.cg.ft.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public  interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUserName(String username);
    Optional<User> findByUserId(Integer Id);

}

