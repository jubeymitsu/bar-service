package ru.rogov.barservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "identifier")
    private String identifier;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DrinkOrder> drinks = new ArrayList<>();

//    public void addDrink(Drink drink, int amount) {
//        DrinkOrder drinkOrder = new DrinkOrder(drink, amount);
//        drinks.add(drinkOrder);
//    }
//
//    public void removeDrink(Drink drink) {
//        drinks.removeIf(drinkOrder -> drinkOrder.getDrink().equals(drink));
//    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

}
