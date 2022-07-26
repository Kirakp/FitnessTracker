package com.cg.ft.repository;

import com.cg.ft.entities.User;
import com.cg.ft.entities.UserDiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDietRepository extends JpaRepository<UserDiet,Integer> {
    UserDiet findUserDietByUserId(User user);
}
