package com.cg.ft.services;

import com.cg.ft.entities.User;
import com.cg.ft.exception.UserNotFoundException;
import com.cg.ft.repository.AdminRepository;
import com.cg.ft.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @InjectMocks
    private AdminService adminService;

    @Mock
    private UserRepository userRepository;

    @Test
    void testGetUserById() {

        User user = new User();
        user.setUserId(1);
        user.setUserName("name");
        user.setName("xo");
        user.setPassword("password");
        user.setContact("99743843");
        user.setDob(LocalDate.of(2022, 1, 1));
        user.setHeight(6);
        user.setWeight(80);

        Optional<User> optionalUser = Optional.of(user);

        when(userRepository.findById(1)).thenReturn(optionalUser);

        User myUser = userService.getUserById(1);
        assertEquals("xo", myUser.getName());
    }

    @Test
    void testGetUserByIdWithException() {

        when(userRepository.findById(1)).thenThrow(UserNotFoundException.class);

        assertThrows(UserNotFoundException.class, ()->userService.getUserById(1));
    }

    @Test
    void testGetAllUsers(){

        User user = new User();
        user.setUserId(1);
        user.setUserName("name");
        user.setName("xo");
        user.setPassword("password");
        user.setContact("99743843");
        user.setDob(LocalDate.of(2022, 1, 1));
        user.setHeight(6);
        user.setWeight(80);

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("pra");
        user2.setName("pran");
        user2.setPassword("pass");
        user2.setContact("7985234");
        user2.setDob(LocalDate.of(2000, 10, 1));
        user2.setHeight(5);
        user2.setWeight(70);

        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("sam");
        user3.setName("samrox");
        user3.setPassword("sam@123");
        user3.setContact("4238234890");
        user3.setDob(LocalDate.of(1964, 8, 12));
        user3.setHeight(7);
        user3.setWeight(98);

        List<User> userList= new ArrayList<>();
        userList.add(user3);
        userList.add(user2);
        userList.add(user);

        when(userRepository.findAll()).thenReturn(userList);

        List<User> users = userService.getAllUsers();
        assertEquals(3,users.size());
    }

    @Test
    void testRegisterUser() {
        User user= new User();
        user.setUserId(1);
        user.setUserName("name");
        user.setName("xo");
        user.setPassword("password");
        user.setContact("99743843");
        user.setDob(LocalDate.of(2022, 1, 1));
        user.setHeight(6);
        user.setWeight(80);

        when(userRepository.save(user)).thenReturn(user);

        User myUser = userService.registerUser(user);

        assertEquals("xo", myUser.getName());

        verify(userRepository,times(1)).save(user); //Useful for testing void methods

    }

    @Test
    void testDeleteUser() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("name");
        user.setName("xo");
        user.setPassword("password");
        user.setContact("99743843");
        user.setDob(LocalDate.of(2022, 1, 1));
        user.setHeight(6);
        user.setWeight(80);

        Optional<User> optionalUser = Optional.of(user);

        when(userRepository.findById(1)).thenReturn(optionalUser);

        User myUser = userService.getUserById(1);

        adminService.deleteUser(1);

        verify(userRepository,times(1)).findById(1);
        verify(userRepository, times(1)).deleteById(1);

    }


}
