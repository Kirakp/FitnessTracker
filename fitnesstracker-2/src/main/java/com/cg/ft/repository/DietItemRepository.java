package com.cg.ft.repository;

import com.cg.ft.entities.DietItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietItemRepository extends JpaRepository<DietItem,Integer> {

}
