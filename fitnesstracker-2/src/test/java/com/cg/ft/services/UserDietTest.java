package com.cg.ft.services;

import com.cg.ft.entities.*;
import com.cg.ft.repository.UserDietRepository;
import com.cg.ft.serviceImpl.UserDietServiceImpl;
import com.cg.ft.services.UserDietService;
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
import static org.mockito.Mockito.times;

@SpringBootTest
public class UserDietTest {


    @InjectMocks
    private UserDietService userDietService = new UserDietServiceImpl();


    @Mock
    private UserDietRepository userDietRepository;



    @Test
    public void testGetUserDiet() {


        UserDiet userDiet1 = new UserDiet();
        userDiet1.setDietId(new Diet( new DietItem("dosa","pancake", "roti and dal","biscuits and tea", "fried rice"  ), "muscle"));
        userDiet1.setUserId(new User("name1","x", "password", "7975226448", 150, 60, LocalDate.now()));
        userDiet1.setNo_of_days(4);

        UserDiet userDiet2 = new UserDiet();
        userDiet1.setDietId(new Diet( new DietItem("idli","egg", "roti and dal","biscuits and tea", " rice"  ), "weightloss"));
        userDiet1.setUserId(new User("name2","y", "password1", "7975226548", 140, 50, LocalDate.now()));
        userDiet1.setNo_of_days(3);


        List<UserDiet> userDietList = new ArrayList<>(Arrays.asList(userDiet2, userDiet1));
        when(userDietRepository.findAll()).thenReturn(userDietList);
        List<UserDiet> userDiets = userDietService.viewDiets();
        assertEquals(2,userDiets.size());
    }

    @Test
    public void testAddUserDiet(){

        UserDiet userDiet1 = new UserDiet();
        userDiet1.setDietId(new Diet( new DietItem("dosa","pancake", "roti and dal","biscuits and tea", "fried rice"  ), "muscle"));
        userDiet1.setUserId(new User("pranay","kp1", "password", "7975226448", 150, 60, LocalDate.now()));
        userDiet1.setNo_of_days(4);

        when(userDietRepository.save(userDiet1)).thenReturn(userDiet1);
        UserDiet newUserDiet = userDietService.addUserDiet(userDiet1);
        assertEquals(4, newUserDiet.getNo_of_days());
        verify(userDietRepository,times(1)).save(userDiet1);

    }

//    @Test
//    public void testDeleteUserDiet(){
//
//        UserDiet userDiet1 = new UserDiet();
//        userDiet1.setDietId(new Diet( new DietItem("dosa","pancake", "roti and dal","biscuits and tea", "fried rice"  ), "muscle"));
//        userDiet1.setUserId(new User("name","kp1", "password", "7975226448", 150, 60, LocalDate.now()));
//        userDiet1.setNo_of_days(4);
//
//        Optional<UserDiet> optionalUserDiet = Optional.of(userDiet1);
//        when(userDietRepository.findById(1)).thenReturn(optionalUserDiet);
//        userDietService.deleteDiet(1);
//        verify(userDietRepository,times(1)).findById(1);
//        verify(userDietRepository, times(1)).deleteById(1);
//
//    }


}