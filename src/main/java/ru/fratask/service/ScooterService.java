package ru.fratask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fratask.exception.CheckException;
import ru.fratask.model.dto.ScooterDto;
import ru.fratask.model.entity.Scooter;
import ru.fratask.model.mapper.ScooterMapper;
import ru.fratask.repository.ScooterRepository;

import static ru.fratask.exception.CheckExceptionMessages.NOT_FOUND_ID;
import static ru.fratask.exception.CheckExceptionMessages.NOT_FOUND_SCOOTER;
import static ru.fratask.exception.CheckExceptionMessages.NOT_NULL_ID;

@Service
public class ScooterService {

    @Autowired
    private ScooterRepository repository;

    @Autowired
    private ScooterMapper mapper;

    public ScooterDto create(ScooterDto dto) {
        if (dto.getId() != null) {
            throw new CheckException(NOT_NULL_ID);
        }
        Scooter entity = new Scooter();
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setChargeLevel(dto.getChargeLevel());
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    public ScooterDto update(ScooterDto dto) {
        if (dto.getId() == null) {
            throw new CheckException(NOT_FOUND_ID);
        }

        Scooter entity = repository.findById(dto.getId())
                .orElseThrow(() -> new CheckException(NOT_FOUND_SCOOTER));

        boolean updated = false;

        if (!entity.getLatitude().equals(dto.getLatitude())) {
            updated = true;
            entity.setLatitude(dto.getLatitude());
        }

        if (!entity.getLongitude().equals(dto.getLongitude())) {
            updated = true;
            entity.setLongitude(dto.getLongitude());
        }

        if (!entity.getChargeLevel().equals(dto.getChargeLevel())) {
            updated = true;
            entity.setChargeLevel(dto.getChargeLevel());
        }

        if (updated) {
            entity = repository.save(entity);
            return mapper.toDto(entity);
        }

        return null;
    }

    public ScooterDto getScooterById(Long id) {
        if (id == null) {
            throw new CheckException(NOT_FOUND_SCOOTER);
        }
        Scooter entity = repository.findById(id)
                .orElseThrow(() -> new CheckException(NOT_FOUND_SCOOTER));
        return mapper.toDto(entity);
    }
}
