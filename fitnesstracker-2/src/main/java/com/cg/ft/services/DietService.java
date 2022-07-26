package com.cg.ft.services;

import java.util.List;

import com.cg.ft.entities.Diet;
import com.cg.ft.entities.DietItem;

public interface DietService {

    public List<Diet> getDietType();
    public Diet addDiet(Diet diet);

    Diet getDietById(Integer i);

}
