package com.cg.ft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ft.entities.Diet;

@Repository
public interface DietRepository extends JpaRepository<Diet, Integer> {

}
