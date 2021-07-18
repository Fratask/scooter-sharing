package ru.fratask.model.dto;

public class TariffDto {
    private Long id;

    private String name;

    private Long pricePerMinute;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(Long pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }
}
