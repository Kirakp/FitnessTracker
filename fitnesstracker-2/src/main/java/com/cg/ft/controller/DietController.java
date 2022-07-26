package com.cg.ft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.ft.entities.Diet;
import com.cg.ft.services.DietService;

@RestController
@RequestMapping(path="/diet")
@CrossOrigin(origins = "http://localhost:3000")
public class DietController {

    @Autowired
    private DietService dietService;

    @GetMapping(path="/getdiet")
    public List<Diet>getDiet()
    {
        return this.dietService.getDietType();
    }

    @PostMapping(path="/adddiet")
    public Diet addDiet(@RequestBody Diet diet) {
        return this.dietService.addDiet(diet);

    }
}
