package com.cg.ft.controller;

import java.util.List;

import com.cg.ft.entities.DietItem;
import com.cg.ft.services.DietItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/diet_item")
@CrossOrigin(origins = "http://localhost:3000")
public class DietItemController {

    @Autowired
    private DietItemService dietItemService;

    @GetMapping(path="/get_diet")
    public List<DietItem> getdiet()
    {
        return this.dietItemService.getDietItem();
    }

    @PostMapping(path="/add_diet")
    public DietItem addDietItem(@RequestBody DietItem dietItem) {
        return this.dietItemService.addDietItem(dietItem);

    }
}
