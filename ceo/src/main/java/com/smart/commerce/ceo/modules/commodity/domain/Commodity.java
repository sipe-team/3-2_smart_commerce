package com.smart.commerce.ceo.modules.commodity.domain;

import com.smart.commerce.ceo.modules.commodity.infrastructure.CommodityEntity;

import java.util.UUID;

public class Commodity {
    private final CommodityId id;
    private final CommodityName name;
    private CommodityPrice price;

    public Commodity(CommodityId id, CommodityName name, CommodityPrice price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Commodity(UUID id, String name, Integer price) {
        this.id = new CommodityId(id);
        this.name = new CommodityName(name);
        this.price = new CommodityPrice(price);
    }

    public CommodityId getId() {
        return id;
    }

    public CommodityName getName() {
        return name;
    }

    public CommodityPrice getPrice() {
        return price;
    }

    public void changePrice(CommodityPrice newPrice) {
        if(newPrice == null) throw new IllegalArgumentException("가격은 null일 수 없습니다.");
        this.price = newPrice;
    }

    public CommodityEntity toEntity() {
        return new CommodityEntity(id, name, price);
    }
}
