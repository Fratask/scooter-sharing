package ru.fratask.model.mapper;

import org.mapstruct.Mapper;
import ru.fratask.model.dto.ScooterDto;
import ru.fratask.model.entity.Scooter;

@Mapper(componentModel = "spring")
public interface ScooterMapper {

    ScooterDto toDto(Scooter scooter);
    Scooter fromDto(ScooterDto dto);
}
