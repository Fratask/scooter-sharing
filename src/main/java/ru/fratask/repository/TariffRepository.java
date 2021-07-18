package ru.fratask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fratask.model.entity.Tariff;

public interface TariffRepository extends JpaRepository<Tariff, Long> {
}
