package com.smart.commerce.ceo.modules.commodity.infrastructure;

import com.smart.commerce.ceo.modules.commodity.domain.Commodity;
import com.smart.commerce.ceo.modules.commodity.domain.CommodityId;
import com.smart.commerce.ceo.modules.commodity.domain.CommodityRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CommodityRepositoryImpl implements CommodityRepository{
    private final CommodityEntityRepository commodityEntityRepository;

    public CommodityRepositoryImpl(CommodityEntityRepository commodityEntityRepository) {
        this.commodityEntityRepository = commodityEntityRepository;
    }

    @Override
    @Transactional
    public void save(Commodity commodity) {
        CommodityEntity commodityEntity = commodity.toEntity();
        commodityEntityRepository.save(commodityEntity);
    }

    @Override
    public List<Commodity> findAll() {
        return commodityEntityRepository.findAllByOrderByIdDesc()
                .stream()
                .map(CommodityEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Commodity> findById(CommodityId id) {
        return Optional.of(commodityEntityRepository.findById(id.getValue())
                .map(CommodityEntity::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다.")));
    }

}
