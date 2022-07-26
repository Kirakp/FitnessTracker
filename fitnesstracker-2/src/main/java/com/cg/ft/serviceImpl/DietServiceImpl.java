package com.cg.ft.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.cg.ft.entities.DietItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ft.entities.Diet;
import com.cg.ft.repository.DietRepository;
import com.cg.ft.services.DietService;

@Service
public class DietServiceImpl implements DietService{

    @Autowired
    private DietRepository dietRepository;
    public DietServiceImpl(){

    }

    @Override
    public List<Diet> getDietType() {
        return dietRepository.findAll();
    }

    @Override
    public Diet addDiet(Diet diet) {
        dietRepository.save(diet);
        return diet;
    }

    @Override
    public Diet getDietById(Integer id) {
        Optional<Diet> optionalDiet = dietRepository.findById(id);
        Diet diet = optionalDiet.get();
        return diet;
    }

}
