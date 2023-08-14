package ru.rogov.barservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rogov.barservice.dto.DrinkDTO;
import ru.rogov.barservice.mapper.DrinkMapper;
import ru.rogov.barservice.service.drink.DrinkService;
import ru.rogov.barservice.storage.StorageService;

@RestController
public class MainController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private DrinkService drinkService;

    @Autowired
    private DrinkMapper drinkMapper;
    @GetMapping("/hello")
    public String testHello(){
        return "Hello world!";
    }

    @PostMapping("/drinkUpload")
    public String handleFileUpload(DrinkDTO drinkDTO) {
        System.out.println("INSIDE DRINKS");
        storageService.store(drinkDTO.getPhoto());
        drinkService.addDrink(drinkMapper.DTOtoEntity(drinkDTO));
        return "success";
    }

}
