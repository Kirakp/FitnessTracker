package com.cg.ft.controller;

import com.cg.ft.entities.User;
import com.cg.ft.entities.UserActivity;
import com.cg.ft.services.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserActivityController {

    @Autowired
    private UserActivityService userActivityService;

    @RequestMapping(path = "/useractivity")
    public List<UserActivity> viewActivity(){
        return this.userActivityService.viewActivities();
    }

    @GetMapping(path = "/useractivity/{id}")
    public UserActivity getUAById(@PathVariable Integer id){
        return this.userActivityService.getUserActivityByUserId(id);
    }

    @PostMapping(path="/useractivity/addUserActivity")
    public UserActivity addUserActivity(@RequestBody UserActivity userActivity){
        return this.userActivityService.addActivity(userActivity);
    }

    @DeleteMapping(path="/useractivity/delete/{userActivity_id}")
    public ResponseEntity<HttpStatus> deleteActivity(@PathVariable Integer userActivity_id){
        try{
            this.userActivityService.deleteActivity(Integer.parseInt(String.valueOf(userActivity_id)));
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(path = "/useractivity/update/{userId}")
    public UserActivity updateUserActivity(@PathVariable  Integer userId, @RequestBody UserActivity userActivity){
        return this.userActivityService.updateActivity(userId,userActivity);
    }

}
