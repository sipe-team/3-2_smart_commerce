package com.smart.commerce.ceo.modules.commodity.api.dto;

import com.smart.commerce.ceo.modules.commodity.domain.Commodity;

import java.util.UUID;

public record CommodityResponse(
        UUID id,
        String name,
        Integer price
) {
    public static CommodityResponse of(Commodity commodity){
        return new CommodityResponse(commodity.getId().getValue(),
                commodity.getName().getValue(), commodity.getPrice().getValue());
    }
}
