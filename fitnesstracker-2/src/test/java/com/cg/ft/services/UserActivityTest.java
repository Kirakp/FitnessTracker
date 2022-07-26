package com.cg.ft.services;

import com.cg.ft.entities.Activity;
import com.cg.ft.entities.Admin;
import com.cg.ft.entities.User;
import com.cg.ft.entities.UserActivity;
import com.cg.ft.repository.UserActivityRepository;
import com.cg.ft.serviceImpl.UserActivityServiceImpl;
import com.cg.ft.services.UserActivityService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserActivityTest {

    @InjectMocks
    private UserActivityService userActivityService = new UserActivityServiceImpl();


    @Mock
    private UserActivityRepository userActivityRepository;



    @Test
    public void testGetUserActivity() {


        UserActivity userActivity1 = new UserActivity();
        userActivity1.setActivityId(new Activity("yoga", 146.0F, 900.0F));
        userActivity1.setUserId(new User("name1","x", "password", "7975226448", 150, 60, LocalDate.now()));
        userActivity1.setFrequency(3);
        userActivity1.setTotal_calories(100);
        userActivity1.setStart_date(LocalDate.now());

        UserActivity userActivity2 = new UserActivity();
        userActivity1.setActivityId(new Activity("cycling", 156.0F, 500.0F));
        userActivity1.setUserId(new User("pranay","y", "password1", "7977226448", 160, 50, LocalDate.now()));
        userActivity1.setFrequency(5);
        userActivity1.setTotal_calories(10);
        userActivity1.setStart_date(LocalDate.now());

        List<UserActivity> userActivityList = new ArrayList<>(Arrays.asList(userActivity1, userActivity2));
        when(userActivityRepository.findAll()).thenReturn(userActivityList);
        List<UserActivity> activities = userActivityService.viewActivities();
        assertEquals(2,activities.size());
    }

    @Test
    public void testAddActivity(){

        UserActivity userActivity1 = new UserActivity();
        userActivity1.setActivityId(new Activity("yoga", 146.0F, 900.0F));
        userActivity1.setUserId(new User("name","kp1", "password", "7975226448", 150, 60, LocalDate.now()));
        userActivity1.setFrequency(3);
        userActivity1.setTotal_calories(100);
        userActivity1.setStart_date(LocalDate.now());


        when(userActivityRepository.save(userActivity1)).thenReturn(userActivity1);
        UserActivity newUserActivity = userActivityService.addActivity(userActivity1);
        assertEquals(3, newUserActivity.getFrequency());
        verify(userActivityRepository,times(1)).save(userActivity1);

    }

//    @Test
//    public void testDeleteActivity(){
//
//        UserActivity userActivity1 = new UserActivity();
//        userActivity1.setActivityId(new Activity("yoga", 146.0F, 900.0F));
//        userActivity1.setUserId(new User("name","kp1", "password", "7975226448", 150, 60, LocalDate.now()));
//        userActivity1.setFrequency(3);
//        userActivity1.setTotal_calories(100);
//        userActivity1.setStart_date(LocalDate.now());
//
//
//        Optional<UserActivity> optionalUserActivity = Optional.of(userActivity1);
//        when(userActivityRepository.findById(1)).thenReturn(optionalUserActivity);
//        userActivityService.deleteActivity(1);
//        verify(userActivityRepository,times(1)).findById(1);
//        verify(userActivityRepository, times(1)).deleteById(1);
//
//    }





}
