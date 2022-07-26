package com.cg.ft.services;

import com.cg.ft.entities.Activity;

import java.util.List;

public interface ActivityService {

    public List<Activity> getActivity();
    public Activity addActivity(Activity activity);

    Activity getActivityById(Integer i);
}
