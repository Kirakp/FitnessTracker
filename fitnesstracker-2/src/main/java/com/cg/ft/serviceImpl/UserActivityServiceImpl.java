package com.cg.ft.serviceImpl;

import com.cg.ft.entities.Activity;
import com.cg.ft.entities.Diet;
import com.cg.ft.entities.User;
import com.cg.ft.entities.UserActivity;
import com.cg.ft.repository.ActivityRepository;
import com.cg.ft.repository.UserActivityRepository;
import com.cg.ft.repository.UserRepository;
import com.cg.ft.services.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserActivityServiceImpl implements UserActivityService {

    @Autowired
    private UserActivityRepository userActivityRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserRepository userRepository;

    public  UserActivityServiceImpl(){

    }
    @Override
    public List<UserActivity> viewActivities() {
        return userActivityRepository.findAll();
    }

    @Override
    public UserActivity addActivity(UserActivity userActivity) {
        userActivityRepository.save(userActivity);
        return userActivity;
    }

    @Override
    public void deleteActivity(Integer userActivity_id) {
        UserActivity userentity=userActivityRepository.getById(userActivity_id);
        userActivityRepository.delete(userentity);
    }

    @Override
    @Transactional
    public UserActivity updateActivity(Integer userId, UserActivity userActivity) {
        Optional<UserActivity> userdata= userActivityRepository.findById(userId);
        if(userdata.isPresent()) {
            userdata.get().setActivityId(userActivity.getActivityId());
            userdata.get().setFrequency(userActivity.getFrequency());
            userdata.get().setTotal_calories(userActivity.getTotal_calories());
            userdata.get().setStart_date(userActivity.getStart_date());
        }
        return userdata.get();
    }

    @Override
    public UserActivity getUserActivityByUserId(Integer id){
        User user = userRepository.findById(id).get();
        return userActivityRepository.findUserActivityByUserId(user);
    }



}
