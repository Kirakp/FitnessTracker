package com.cg.ft.serviceImpl;


import com.cg.ft.entities.DietItem;
import com.cg.ft.repository.DietItemRepository;
import com.cg.ft.services.DietItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DietItemServiceImpl implements DietItemService {

    @Autowired
    private DietItemRepository dietItemRepository;
    public DietItemServiceImpl() {

    }

    @Override
    public List<DietItem> getDietItem() {
        return dietItemRepository.findAll();
    }

    @Override
    public DietItem addDietItem(DietItem dietItem) {
        dietItemRepository.save(dietItem);
        return dietItem;
    }

    @Override
    public DietItem getDietItemById(Integer id) {
        Optional<DietItem> optionalDietItem = dietItemRepository.findById(id);
        DietItem dietItem = optionalDietItem.get();
        return dietItem;
    }
}
