package com.cg.ft.services;

import com.cg.ft.entities.Activity;
import com.cg.ft.repository.ActivityRepository;
import com.cg.ft.serviceImpl.ActivityServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ActivityServiceTest {

    @InjectMocks
    private ActivityService activityService = new ActivityServiceImpl();

    @Mock
    private ActivityRepository activityRepository;

    @Test
    void testGetActivityById() {

        Activity activity = new Activity();
        activity.setActivityId(1);
        activity.setActivityName("cycling");
        activity.setDuration(1.5F);
        activity.setCalories(250.0F);

        Optional<Activity> optionalActivity = Optional.of(activity);

        when(activityRepository.findById(1)).thenReturn(optionalActivity);

        Activity myActivity = activityService.getActivityById(1);
        assertEquals("cycling", myActivity.getActivityName());
    }

    //void testWithException()

    @Test
    void testGetAllActivity(){

        Activity activity = new Activity();
        activity.setActivityId(1);
        activity.setActivityName("cycling");
        activity.setDuration(1.5F);
        activity.setCalories(250.0F);

        Activity activity2 = new Activity();
        activity2.setActivityId(2);
        activity2.setActivityName("running");
        activity2.setDuration(2.2F);
        activity2.setCalories(350.0F);

        Activity activity3 = new Activity();
        activity3.setActivityId(3);
        activity3.setActivityName("swimming");
        activity3.setDuration(0.5F);
        activity3.setCalories(150.0F);

        List<Activity> activityList = new ArrayList<>();
        activityList.add(activity3);
        activityList.add(activity2);
        activityList.add(activity);

        when(activityRepository.findAll()).thenReturn(activityList);

        List<Activity> activities = activityService.getActivity();
        assertEquals(3, activities.size());
    }

    @Test
    void testSaveActivity(){

        Activity activity = new Activity();
        activity.setActivityId(1);
        activity.setActivityName("cycling");
        activity.setDuration(1.5F);
        activity.setCalories(250.0F);

        when(activityRepository.save(activity)).thenReturn(activity);

        Activity myActivity = activityService.addActivity(activity);

        assertEquals("cycling", myActivity.getActivityName());

        verify(activityRepository, times(1)).save(activity);
    }




}
