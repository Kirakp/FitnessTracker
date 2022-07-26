package com.cg.ft.services;


import com.cg.ft.entities.User;
import com.cg.ft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User loginUser(String userValue, String password) {

        Optional<User> userName = userRepository.findUserByUserName(userValue);

        //checking for username and password
        if (userName.isPresent()) {
            if (userName.get().getPassword().equals(password))
                return userName.get();
            else
                throw new IllegalStateException("please enter valid username and password");
        }
        //checking for email and password
        else
            throw new IllegalStateException("User doesn't exists!");


    }

    public User registerUser(User user) {
        Optional<User> userByUserName = userRepository.findUserByUserName(user.getName());
        if (userByUserName.isPresent())
            throw new IllegalStateException("User with username '" + user.getName() + "' already exists.");
        else {
            user.setPassword(user.getPassword());
            System.out.println(user);
            return userRepository.save(user);
        }
    }
//    @Transactional
//    public User UpdateUser(String userValue,User user){
//        Optional<User> u = userRepository.findUserByUserName(userValue);
//
//        if(u.isPresent()) {
//            u.get().setName(user.getName());
//            u.get().setPassword(user.getPassword());
//            u.get().setContact(user.getContact());
//            u.get().setDob(user.getDob());
//            u.get().setHeight(user.getHeight());
//            u.get().setWeight(user.getWeight());
//            return u.get();
//        }
//        else{
//            throw new IllegalStateException("User does not exist");
//        }
//    }

    @Transactional
    public User UpdateUser(Integer id,User user){
        Optional<User> u = userRepository.findById(id);

        if(u.isPresent()) {
            u.get().setUserName(user.getUserName());
            u.get().setName(user.getName());
            u.get().setPassword(user.getPassword());
            u.get().setContact(user.getContact());
            u.get().setDob(user.getDob());
            u.get().setHeight(user.getHeight());
            u.get().setWeight(user.getWeight());
            return u.get();
        }
        else{
            throw new IllegalStateException("User does not exist");
        }
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id ) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }
}
