package ru.rogov.barservice.service.order;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rogov.barservice.entity.Drink;
import ru.rogov.barservice.entity.DrinkOrder;
import ru.rogov.barservice.entity.Order;
import ru.rogov.barservice.entity.OrderStatus;
import ru.rogov.barservice.repo.DrinkRepo;
import ru.rogov.barservice.repo.OrderRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final DrinkRepo drinkRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, DrinkRepo drinkRepo) {
        this.orderRepo = orderRepo;
        this.drinkRepo = drinkRepo;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepo.findAll();
    }

    //FIX ERROR
    @Override
    public Order findOrderById(Long id) {
        return orderRepo.findById(id).orElseThrow();
    }

    @Override
    public Order addOrder(Order order) {
        Order newOrder = new Order();
        List<DrinkOrder> list = new ArrayList<>();

        Random random = new Random();
        String idetnfier = "#ccc" + random.nextInt(55);

        List<DrinkOrder> menu = order.getDrinks();
        menu.forEach(elem -> {
            Drink drink = drinkRepo.findById(elem.getDrink().getId()).get();

            list.add(new DrinkOrder(drink, elem.getAmount()));
        });

        list.forEach(el -> {
            el.setOrder(newOrder);
        });

        newOrder.setIdentifier(idetnfier);
        newOrder.setStatus(OrderStatus.PREPARING);

        newOrder.setDrinks(list);

        return orderRepo.save(newOrder);
    }

    // Can only update order status
    @Override
    public Order updateOrder(Long id, Order order) {
        Order orderFromDB = findOrderById(id);
        orderFromDB.setStatus(order.getStatus());
        return orderRepo.save(orderFromDB);
    }

    @Override
    public Order deleteOrder(Long id) {
        Order orderById = findOrderById(id);
        orderRepo.deleteById(id);
        return orderById;
    }
}
