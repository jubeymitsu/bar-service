package ru.rogov.barservice.service.order;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rogov.barservice.entity.Order;
import ru.rogov.barservice.repo.OrderRepo;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
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
        return orderRepo.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Order orderFromDB = findOrderById(id);
        BeanUtils.copyProperties(order, orderFromDB, "id");
        return orderRepo.save(orderFromDB);
    }

    @Override
    public Order deleteOrder(Long id) {
        Order orderById = findOrderById(id);
        orderRepo.deleteById(id);
        return orderById;
    }
}
