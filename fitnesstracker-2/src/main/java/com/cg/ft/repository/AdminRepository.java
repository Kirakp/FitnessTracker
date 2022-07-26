package com.cg.ft.repository;

import com.cg.ft.entities.Admin;
import com.cg.ft.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findAdminByUserName(String username);
    Optional<Admin> findByAdminId(Integer Id);

}
