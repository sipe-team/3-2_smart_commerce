package com.smart.commerce.ceo.modules.commodity.domain;

import java.util.List;
import java.util.Optional;

public interface CommodityRepository {
    void save(Commodity commodity);
    List<Commodity> findAll(); //TODO: page 처리하기
    Optional<Commodity> findById(CommodityId id);
    boolean existsById(CommodityId id);
    void deleteById(CommodityId id);
}
