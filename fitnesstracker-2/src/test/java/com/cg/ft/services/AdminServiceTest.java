package com.cg.ft.services;

import com.cg.ft.entities.Admin;
import com.cg.ft.entities.User;
import com.cg.ft.exception.AdminNotFoundException;
import com.cg.ft.repository.AdminRepository;
import org.checkerframework.checker.nullness.Opt;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AdminServiceTest {

    @InjectMocks
    private AdminService adminService;

    @Mock
    private AdminRepository adminRepository;

    @Test
    void testGetAdminById() {

        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setPassword("1234");
        admin.setNumber(99439843);
        admin.setUserName("admin");

        Optional<Admin> optionalAdmin = Optional.of(admin);

        when(adminRepository.findById(1)).thenReturn(optionalAdmin);

        Admin myAdmin = adminService.getAdminById(1);
        assertEquals("admin", myAdmin.getUserName());
    }

    @Test
    void testGetAdminByIdWithException(){
        when(adminRepository.findById(1)).thenThrow(AdminNotFoundException.class);

        assertThrows(AdminNotFoundException.class, ()->adminService.getAdminById(1));
    }

    @Test
    void testGetAllAdmin(){

        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setPassword("1234");
        admin.setNumber(99439843);
        admin.setUserName("admin");

        Admin admin2 = new Admin();
        admin2.setAdminId(2);
        admin2.setPassword("qwerty");
        admin2.setNumber(4732843);
        admin2.setUserName("tier1Admin");

        Admin admin3 = new Admin();
        admin3.setAdminId(3);
        admin3.setPassword("zxcvbnm");
        admin3.setNumber(734288943);
        admin3.setUserName("tier2Admin");

        List<Admin> adminList = new ArrayList<>();
        adminList.add(admin3);
        adminList.add(admin2);
        adminList.add(admin);

        when(adminRepository.findAll()).thenReturn(adminList);

        List<Admin> admins = adminService.getAllAdmin();
        assertEquals(3,admins.size());
    }

    @Test
    void testRegisterAdmin(){
        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setPassword("1234");
        admin.setNumber(99439843);
        admin.setUserName("admin");

        when(adminRepository.save(admin)).thenReturn(admin);

        Admin myAdmin = adminService.registerAdmin(admin);

        assertEquals("admin", myAdmin.getUserName());

        verify(adminRepository, times(1)).save(admin); //Useful for testing void methods

    }

    @Test
    void testDeleteAdmin() {
        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setPassword("1234");
        admin.setNumber(99439843);
        admin.setUserName("admin");

        Optional<Admin> optionalAdmin = Optional.of(admin);

        when(adminRepository.findById(1)).thenReturn(optionalAdmin);

        Admin myAdmin = adminService.getAdminById(1);

        adminService.deleteAdmin(1);

        verify(adminRepository, times(1)).findById(1);
        verify(adminRepository, times(1)).deleteById(1);
    }

}
