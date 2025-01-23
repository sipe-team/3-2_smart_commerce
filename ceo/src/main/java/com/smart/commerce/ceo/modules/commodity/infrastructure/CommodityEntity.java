package com.smart.commerce.ceo.modules.commodity.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="commodity")
public class CommodityEntity {
    @Id
    private String id;
    private String name;
    private Integer price;

    protected CommodityEntity() {}

    public CommodityEntity(String id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
