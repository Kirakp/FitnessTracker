package com.cg.ft.controller;

import com.cg.ft.entities.Admin;
import com.cg.ft.entities.User;
import com.cg.ft.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    private final AdminService adminService;


    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("/getadmin")
    public ResponseEntity<List<Admin>> getAllAdmin() {
        return ResponseEntity.ok().body(adminService.getAllAdmin());
    }

    @GetMapping("getadmin/{id}")
    public Admin getAById(@PathVariable Integer id){
        return adminService.getAdminById(id);
    }

    @GetMapping("/getuser")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok().body(adminService.getAllUsers());
    }

    @GetMapping("/getuser/{id}")
    public User getUById(@PathVariable Integer id){
        return adminService.getUserById(id);
    }

    @GetMapping("/get_details")
    public ResponseEntity<User> getUserDetails(@RequestParam(required = true) String userValue) {
        return ResponseEntity.ok().body(adminService.getUserByUserName(userValue));
    }

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/fitness/register").toUriString());
        return ResponseEntity.created(uri).body(adminService.registerAdmin(admin));
    }

    @PutMapping(path = "login/")
    public Admin loginAdmin(@RequestParam(required = true) String userValue,
                            @RequestBody(required = true) String password) {
        return adminService.loginAdmin(userValue, password);
    }

//    @PutMapping(path = "update_admin/")
//    public Admin updateAdmin(@RequestParam(required = true) String userValue,
//                             @RequestBody(required = true) Admin admin){
//        return adminService.UpdateAdmin(userValue,admin);
//    }

    @PutMapping(path = "update_admin/{id}")
    public Admin updateAdmin(@PathVariable Integer id,
                             @RequestBody(required = true) Admin admin){
        return adminService.UpdateAdmin(id,admin);
    }

    @DeleteMapping(path = "delete_admin/")
    public void deleteAdmin(@RequestParam(required = true) Integer id){
        adminService.deleteAdmin(id);
    }

    @DeleteMapping(path = "delete_user/")
    public void deleteUser(@RequestParam(required = true) Integer id){
        adminService.deleteUser(id);
    }
}
