package ru.rogov.barservice.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rogov.barservice.entity.Drink;
import ru.rogov.barservice.service.drink.DrinkService;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    private final DrinkService drinkService;

    @Autowired
    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping("/all")
    public List<Drink> getAllDrinks() {
        return drinkService.findAllDrinks();
    }

    @GetMapping("/{id}")
    public Drink getDrink(@PathVariable Long id) {
        return drinkService.findDrinkById(id);
    }

    @PostMapping("/add")
    public Drink addDrink(@RequestBody @Valid Drink drink) {
        return drinkService.addDrink(drink);
    }

    @PutMapping("/{id}")
    public Drink updateDrink(@PathVariable Long id,
                             @RequestBody Drink drink) {
        return drinkService.updateDrink(id, drink);
    }

    @DeleteMapping("/{id}")
    public Drink deleteDrink(@PathVariable Long id){
        return drinkService.deleteDrink(id);
    }

}
