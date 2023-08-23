package ru.rogov.barservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DrinkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Order order;

    @ManyToOne
    private Drink drink;

    private int amount;

    public DrinkOrder(Order order, Drink drink, int amount) {
        this.order = order;
        this.drink = drink;
        this.amount = amount;
    }

    public DrinkOrder(Drink drink, int amount) {
        this.drink = drink;
        this.amount = amount;
    }
}





