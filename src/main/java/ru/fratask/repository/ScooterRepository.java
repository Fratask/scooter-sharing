package ru.fratask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fratask.model.entity.Scooter;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Long> {
}
