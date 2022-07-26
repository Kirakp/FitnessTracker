package com.cg.ft.controller;

import com.cg.ft.entities.User;
import com.cg.ft.entities.UserActivity;
import com.cg.ft.entities.UserDiet;
import com.cg.ft.services.UserActivityService;
import com.cg.ft.services.UserDietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/userdiet")
@CrossOrigin(origins = "http://localhost:3000")
public class UserDietController {

    @Autowired
    private UserDietService userDietService;

    @GetMapping(path = "/viewDiet")
    public List<UserDiet> viewDiet(){
        return this.userDietService.viewDiets();
    }

    @PostMapping(path="/addUserDiet")
    public UserDiet addUserDiet(@RequestBody UserDiet userDiet){
        return this.userDietService.addUserDiet(userDiet);
    }

    @DeleteMapping(path="/delete/{userDietId}")
    public ResponseEntity<HttpStatus> deleteDiet(@PathVariable Integer userDietId){
        try{
            this.userDietService.deleteDiet(Integer.parseInt(String.valueOf(userDietId)));
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/update/{userId}")
    public UserDiet updateDiet(@PathVariable Integer userId, @RequestBody UserDiet userDiet){
        return this.userDietService.updateDiet(userId,userDiet);
    }

    @GetMapping(path = "/viewDiet/{id}")
    public UserDiet getUserDietById(@PathVariable Integer id){
        return this.userDietService.getUserDietByUserId(id);
    }

}
