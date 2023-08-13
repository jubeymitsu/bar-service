package ru.rogov.barservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rogov.barservice.entity.Drink;

@Repository
public interface DrinkRepo extends JpaRepository<Drink, Long> {
}
