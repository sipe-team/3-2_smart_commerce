package com.smart.commerce.customer.modules.commodity.domain;

import java.util.List;
import java.util.Optional;

public interface CommodityRepository {
    Commodity save(Commodity commodity);
    List<Commodity> findAll(); //TODO: page 처리하기
    Optional<Commodity> findById(CommodityId id);
}
