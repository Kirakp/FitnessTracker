package com.cg.ft.services;

import com.cg.ft.entities.DietItem;
import com.cg.ft.repository.DietItemRepository;
import com.cg.ft.serviceImpl.DietItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DietItemServiceTest {

    @InjectMocks
    private DietItemService dietItemService = new DietItemServiceImpl();

    @Mock
    private DietItemRepository dietItemRepository;


    @Test
    void testGetDietItemById() {

        DietItem dietItem = new DietItem();
        dietItem.setDietItemId(5);
        dietItem.setBreakfast("dosa");
        dietItem.setBrunch("pancake");
        dietItem.setLunch("roti and dal");
        dietItem.setSnack("biscuits and tea");
        dietItem.setDinner("fried rice");

        Optional<DietItem> optionalDietItem = Optional.of(dietItem);

        when(dietItemRepository.findById(5)).thenReturn(optionalDietItem);

        DietItem myDietItem = dietItemService.getDietItemById(5);
        assertEquals("dosa", myDietItem.getBreakfast());
    }


    //void testGetDietItemWithException()

    @Test
    void testGetAllDietItems(){

        DietItem dietItem = new DietItem();
        dietItem.setDietItemId(1);
        dietItem.setBreakfast("dosa");
        dietItem.setBrunch("pancake");
        dietItem.setLunch("roti and dal");
        dietItem.setSnack("biscuits and tea");
        dietItem.setDinner("fried rice");

        DietItem dietItem2 = new DietItem();
        dietItem2.setDietItemId(2);
        dietItem2.setBreakfast("idli");
        dietItem2.setBrunch("cupcake");
        dietItem2.setLunch("borgir");
        dietItem2.setSnack("chips");
        dietItem2.setDinner("fried rice");

        DietItem dietItem3 = new DietItem();
        dietItem3.setDietItemId(3);
        dietItem3.setBreakfast("bacon");
        dietItem3.setBrunch("smoothie");
        dietItem3.setLunch("naan");
        dietItem3.setSnack("tacos");
        dietItem3.setDinner("steak");

        List<DietItem> dietItemList = new ArrayList<>();
        dietItemList.add(dietItem3);
        dietItemList.add(dietItem2);
        dietItemList.add(dietItem);

        when(dietItemRepository.findAll()).thenReturn(dietItemList);

        List<DietItem> dietItems = dietItemService.getDietItem();
        assertEquals(3,dietItems.size());
    }

    @Test
    void testSaveDietItem(){
        DietItem dietItem = new DietItem();
        dietItem.setDietItemId(1);
        dietItem.setBreakfast("dosa");
        dietItem.setBrunch("pancake");
        dietItem.setLunch("roti and dal");
        dietItem.setSnack("biscuits and tea");
        dietItem.setDinner("fried rice");

        when(dietItemRepository.save(dietItem)).thenReturn(dietItem);

        DietItem myDietItem = dietItemService.addDietItem(dietItem);

        assertEquals("dosa", myDietItem.getBreakfast());

        verify(dietItemRepository,times(1)).save(dietItem);

    }



    }
