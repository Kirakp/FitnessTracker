package com.cg.ft.services;

import com.cg.ft.entities.DietItem;

import java.util.List;

public interface DietItemService {
    public List<DietItem> getDietItem();
    public DietItem addDietItem(DietItem dietItem);

    DietItem getDietItemById(Integer i);
}
