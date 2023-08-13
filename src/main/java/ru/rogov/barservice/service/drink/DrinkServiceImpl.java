package ru.rogov.barservice.service.drink;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rogov.barservice.entity.Drink;
import ru.rogov.barservice.repo.DrinkRepo;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepo drinkRepo;

    @Autowired
    public DrinkServiceImpl(DrinkRepo drinkRepo) {
        this.drinkRepo = drinkRepo;
    }

    @Override
    public List<Drink> findAllDrinks() {
        return drinkRepo.findAll();
    }

    //FIX ERROR
    @Override
    public Drink findDrinkById(Long id) {
        return drinkRepo.findById(id).orElseThrow();
    }

    @Override
    public Drink addDrink(Drink drink) {
        return drinkRepo.save(drink);
    }

    @Override
    public Drink updateDrink(Long id, Drink drink) {
        Drink drinkFromDB = findDrinkById(id);
        BeanUtils.copyProperties(drink, drinkFromDB, "id");
        return drinkRepo.save(drinkFromDB);
    }

    @Override
    public Drink deleteDrink(Long id) {
        Drink drinkById = findDrinkById(id);
        drinkRepo.deleteById(id);
        return drinkById;
    }
}
