package ru.fratask.model.mapper;

import org.mapstruct.Mapper;
import ru.fratask.model.dto.TariffDto;
import ru.fratask.model.entity.Tariff;

@Mapper(componentModel = "spring")
public interface TariffMapper {

    TariffDto toDto(Tariff tariff);
    Tariff fromDto(TariffDto dto);
}
