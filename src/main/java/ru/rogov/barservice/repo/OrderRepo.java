package ru.rogov.barservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rogov.barservice.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
