package ru.fratask.exception;

public interface CheckExceptionMessages {

    String NOT_NULL_ID = "Создаваемая сущность не должна иметь уникальный идентификатор ";
    String NOT_FOUND_ID = "Не найден уникальной идентификатор ";
    String NOT_FOUND_SCOOTER = "Самокат не найден ";
    String NOT_FOUND_TARIFF = "Тариф не найден ";
    String UNKNOWN_EXCEPTION = "Неизвестная ошибка";
}
