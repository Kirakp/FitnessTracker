package com.cg.ft.services;

import com.cg.ft.entities.Diet;
import com.cg.ft.entities.User;
import com.cg.ft.entities.UserActivity;

import javax.transaction.Transactional;
import java.util.List;

public interface UserActivityService {

    public List<UserActivity> viewActivities();
    public UserActivity addActivity(UserActivity userActivity);
    public void deleteActivity(Integer userActivity_id);
    public UserActivity updateActivity(Integer userId, UserActivity userActivity);
    UserActivity getUserActivityByUserId(Integer id);

}
