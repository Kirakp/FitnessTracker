package com.cg.ft.repository;

import com.cg.ft.entities.Activity;
import com.cg.ft.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Integer> {
        //Optional<Activity> findActivitybyActivityName(String activityname);
        //Optional<User> findByActivityId(Integer Id);
}
