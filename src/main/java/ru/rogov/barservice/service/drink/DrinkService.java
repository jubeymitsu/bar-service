package ru.rogov.barservice.service.drink;

import ru.rogov.barservice.entity.Drink;

import java.util.List;

public interface DrinkService {

    List<Drink> findAllDrinks();
    Drink findDrinkById(Long id);
    Drink addDrink(Drink drink);
    Drink updateDrink(Long id, Drink drink);
    Drink deleteDrink(Long id);
}
