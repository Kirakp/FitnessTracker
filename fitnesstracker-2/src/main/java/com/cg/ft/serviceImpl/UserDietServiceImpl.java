package com.cg.ft.serviceImpl;

import com.cg.ft.entities.User;
import com.cg.ft.entities.UserActivity;
import com.cg.ft.entities.UserDiet;
import com.cg.ft.repository.DietRepository;
import com.cg.ft.repository.UserDietRepository;
import com.cg.ft.repository.UserRepository;
import com.cg.ft.services.UserDietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserDietServiceImpl implements UserDietService {



    @Autowired
    private UserDietRepository userDietRepository;

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private UserRepository userRepository;

    public  UserDietServiceImpl(){
    }

    @Override
    public List<UserDiet> viewDiets() {
        return userDietRepository.findAll();
    }

    @Override
    public UserDiet addUserDiet(UserDiet userDiet) {
        userDietRepository.save(userDiet);
        return userDiet;
    }


    @Override
    public void deleteDiet(Integer userDietId) {
        UserDiet userentity=userDietRepository.getById(userDietId);
        userDietRepository.delete(userentity);
    }

    @Override
    @Transactional
    public UserDiet updateDiet(Integer userId, UserDiet userDiet) {
        Optional<UserDiet> userdata= userDietRepository.findById(userId);
        if(userdata.isPresent()) {
            userdata.get().setDietId(userDiet.getDietId());
            userdata.get().setNo_of_days(userDiet.getNo_of_days());
        }
        return userdata.get();
    }

    @Override
    public UserDiet getUserDietByUserId(Integer id){
        User user = userRepository.findById(id).get();
        return userDietRepository.findUserDietByUserId(user);
    }
}
