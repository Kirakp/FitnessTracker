package com.cg.ft.services;

import com.cg.ft.entities.Admin;

import com.cg.ft.entities.User;
import com.cg.ft.repository.AdminRepository;
import com.cg.ft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {


    private AdminRepository adminRepository;
    private UserRepository userRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;

    }

    public Admin loginAdmin(String userValue, String password) {

        Optional<Admin> userName = adminRepository.findAdminByUserName(userValue);

        //checking for username and password
        if (userName.isPresent()) {
            if (userName.get().getPassword().equals(password))
                return userName.get();
            else
                throw new IllegalStateException("please enter valid username and password");
        }
        //checking for email and password
        else
            throw new IllegalStateException("Admin doesn't exists!");


    }

    public Admin registerAdmin(Admin admin) {
        Optional<Admin> adminByUserName = adminRepository.findAdminByUserName(admin.getUserName());
        if (adminByUserName.isPresent())
            throw new IllegalStateException("Admin with username '" + admin.getUserName() + "' already exists.");
        else {
            admin.setPassword(admin.getPassword());
            System.out.println(admin);
            return adminRepository.save(admin);
        }
    }

//    @Transactional
//    public Admin UpdateAdmin(String userValue,Admin admin){
//        Optional<Admin> a = adminRepository.findAdminByUserName(userValue);
//        if(a.isPresent()) {
//
//            a.get().setPassword(admin.getPassword());
//            a.get().setNumber(admin.getNumber());
//
//            return a.get();
//        }
//        else{
//            throw new IllegalStateException("Admin does not exist");
//        }
//    }

    @Transactional
    public Admin UpdateAdmin(Integer id,Admin admin){
        Optional<Admin> a = adminRepository.findById(id);
        if(a.isPresent()) {
            a.get().setUserName(admin.getUserName());
            a.get().setPassword(admin.getPassword());
            a.get().setNumber(admin.getNumber());

            return a.get();
        }
        else{
            throw new IllegalStateException("Admin does not exist");
        }
    }

    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    public void deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUserName(String username) {
        Optional<User> user = userRepository.findUserByUserName(username);
        if (user.isPresent()) {
            User p = user.get();
//            p.setPassword(passwordEncoder.);
            return user.get();
        } else throw new IllegalStateException("User doesn't exists!");
    }

    public User getUserById(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    public Admin getAdminById(Integer id){
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        return optionalAdmin.get();
    }


}
