package ru.rogov.barservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rogov.barservice.entity.Photo;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Long> {
}
