package ru.rogov.barservice.service.order;

import ru.rogov.barservice.entity.Drink;
import ru.rogov.barservice.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrders();
    Order findOrderById(Long id);
    Order addOrder(Order order);
    Order updateOrder(Long id, Order order);
    Order deleteOrder(Long id);
}
