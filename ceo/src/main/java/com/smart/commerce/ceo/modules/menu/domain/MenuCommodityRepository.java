package com.smart.commerce.ceo.modules.menu.domain;

import com.smart.commerce.ceo.modules.commodity.domain.Commodity;

@FunctionalInterface
public interface MenuCommodityRepository {
    Commodity findById(int id);
}
