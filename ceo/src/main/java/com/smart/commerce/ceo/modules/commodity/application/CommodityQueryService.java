package com.smart.commerce.ceo.modules.commodity.application;

import com.smart.commerce.ceo.modules.commodity.domain.Commodity;

import java.util.UUID;

@FunctionalInterface
public interface CommodityQueryService {
    Commodity getCommodity(UUID commodityIdStr);
}
