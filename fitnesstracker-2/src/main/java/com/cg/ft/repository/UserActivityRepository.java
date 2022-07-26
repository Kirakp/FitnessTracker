package com.cg.ft.repository;

import com.cg.ft.entities.User;
import com.cg.ft.entities.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity,Integer> {
    UserActivity findUserActivityByUserId(User user);

}
