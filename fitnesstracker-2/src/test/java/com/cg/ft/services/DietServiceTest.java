package com.cg.ft.services;

import com.cg.ft.entities.Diet;
import com.cg.ft.entities.DietItem;
import com.cg.ft.repository.DietRepository;
import com.cg.ft.serviceImpl.DietServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DietServiceTest {

    @InjectMocks
    private DietService dietService = new DietServiceImpl();

    @Mock
    private DietRepository dietRepository;

    @Test
    void testGetDietById(){
        Diet diet = new Diet();
        diet.setDietId(1);
        diet.setDietItemId(new DietItem("dosa", "pancake", "roti and dal","biscuits and tea", "fried rice" ));
        diet.setDietType("muscle");

        Optional<Diet> optionalDiet = Optional.of(diet);

        when(dietRepository.findById(1)).thenReturn(optionalDiet);

        Diet myDiet = dietService.getDietById(1);
        assertEquals("muscle", myDiet.getDietType());
    }
    //void testGetDietWithException()

    @Test
    void testGetAllDiet(){

        Diet diet = new Diet();
        diet.setDietId(1);
        diet.setDietItemId(new DietItem("dosa", "pancake", "roti and dal","biscuits and tea", "fried rice" ));
        diet.setDietType("muscle");

        Diet diet2 = new Diet();
        diet2.setDietId(2);
        diet2.setDietItemId(new DietItem("oats", "green tea", "roti and dal","apple", "salad" ));
        diet2.setDietType("weight loss");

        Diet diet3 = new Diet();
        diet3.setDietId(2);
        diet3.setDietItemId(new DietItem("oats", "smoothie", "eggs","coffee", "eggs" ));
        diet3.setDietType("weight");

        List<Diet> dietList = new ArrayList<>();
        dietList.add(diet3);
        dietList.add(diet2);
        dietList.add(diet);

        when(dietRepository.findAll()).thenReturn(dietList);

        List<Diet> diets = dietService.getDietType();
        assertEquals(3, diets.size());
    }

    @Test
    void testSaveDiet(){
        Diet diet = new Diet();
        diet.setDietId(1);
        diet.setDietItemId(new DietItem("dosa", "pancake", "roti and dal","biscuits and tea", "fried rice" ));
        diet.setDietType("muscle");

        when(dietRepository.save(diet)).thenReturn(diet);

        Diet myDiet = dietService.addDiet(diet);

        assertEquals("muscle", myDiet.getDietType());

        verify(dietRepository,times(1)).save(diet);
    }

}
