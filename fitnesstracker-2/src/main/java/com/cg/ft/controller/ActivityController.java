package com.cg.ft.controller;

import com.cg.ft.entities.Activity;
import com.cg.ft.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping(path = "/activity")
    //get all activities
    public List<Activity> getActivity(){
        return this.activityService.getActivity();
    }

    @PostMapping(path = "/activity/addactivity")
    public Activity addActivity(@RequestBody Activity activity)
    {
        return this.activityService.addActivity(activity);
    }

}
