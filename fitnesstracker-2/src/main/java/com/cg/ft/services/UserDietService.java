package com.cg.ft.services;

import com.cg.ft.entities.User;

import com.cg.ft.entities.UserDiet;

import java.util.List;

public interface UserDietService {

    public List<UserDiet> viewDiets();
    public UserDiet getUserDietByUserId(Integer id);
    public UserDiet addUserDiet(UserDiet userDiet);
    public void deleteDiet(Integer userDietId);
    public UserDiet updateDiet(Integer userId, UserDiet userDiet);

}
