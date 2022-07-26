package com.cg.ft.serviceImpl;

import com.cg.ft.entities.Activity;
import com.cg.ft.entities.DietItem;
import com.cg.ft.repository.ActivityRepository;
import com.cg.ft.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    public ActivityServiceImpl() {

    }

    @Override
    public List<Activity> getActivity() {
        return activityRepository.findAll();
    }

    @Override
    public Activity addActivity(Activity activity) {
        activityRepository.save(activity);
        return activity;
    }

    @Override
    public Activity getActivityById(Integer id) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);
        Activity activity = optionalActivity.get();
        return activity;
    }
}
