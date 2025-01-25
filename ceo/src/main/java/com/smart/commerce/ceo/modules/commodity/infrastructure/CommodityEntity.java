package com.smart.commerce.ceo.modules.commodity.infrastructure;

import com.smart.commerce.ceo.modules.commodity.domain.Commodity;
import com.smart.commerce.ceo.modules.commodity.domain.CommodityId;
import com.smart.commerce.ceo.modules.commodity.domain.CommodityName;
import com.smart.commerce.ceo.modules.commodity.domain.CommodityPrice;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="commodity")
public class CommodityEntity {
    @Id
    private UUID id;
    private String name;
    private Integer price;

    public CommodityEntity() {
    }

    public CommodityEntity(CommodityId id, CommodityName name, CommodityPrice price) {
        this.id = id.getValue();
        this.name = name.getValue();
        this.price = price.getValue();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Commodity toDomain() {
        return new Commodity(id, name, price);
    }
}
