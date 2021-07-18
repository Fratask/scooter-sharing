package ru.fratask.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "tariffs")
public class Tariff {

    @Id
    @SequenceGenerator(name = "tariffs_id_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tariffs_id_generator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price_per_minute")
    private Integer pricePerMinute;

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

    public Integer getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(Integer pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }
}
