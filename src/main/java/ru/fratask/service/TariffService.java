package ru.fratask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fratask.exception.CheckException;
import ru.fratask.model.dto.ScooterDto;
import ru.fratask.model.dto.TariffDto;
import ru.fratask.model.entity.Scooter;
import ru.fratask.model.entity.Tariff;
import ru.fratask.model.mapper.TariffMapper;
import ru.fratask.repository.TariffRepository;

import static ru.fratask.exception.CheckExceptionMessages.*;
import static ru.fratask.exception.CheckExceptionMessages.NOT_FOUND_SCOOTER;

@Service
public class TariffService {

    @Autowired
    TariffRepository repository;

    @Autowired
    TariffMapper mapper;

    public TariffDto create(TariffDto dto) {
        if (dto.getId() != null) {
            throw new CheckException(NOT_NULL_ID);
        }
        Tariff entity = new Tariff();
        entity.setName(dto.getName());
        entity.setPricePerMinute(dto.getPricePerMinute());
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    public TariffDto update(TariffDto dto) {
        if (dto.getId() == null) {
            throw new CheckException(NOT_FOUND_ID);
        }

        Tariff entity = repository.findById(dto.getId())
                .orElseThrow(() -> new CheckException(NOT_FOUND_SCOOTER));

        boolean updated = false;

        if (!entity.getName().equals(dto.getName())) {
            updated = true;
            entity.setName(dto.getName());
        }

        if (!entity.getPricePerMinute().equals(dto.getPricePerMinute())) {
            updated = true;
            entity.setPricePerMinute(dto.getPricePerMinute());
        }


        if (updated) {
            entity = repository.save(entity);
            return mapper.toDto(entity);
        }

        return null;
    }

    public TariffDto getTariffById(Long id) {
        if (id == null) {
            throw new CheckException(NOT_FOUND_SCOOTER);
        }
        Tariff entity = repository.findById(id)
                .orElseThrow(() -> new CheckException(NOT_FOUND_SCOOTER));
        return mapper.toDto(entity);
    }
}
