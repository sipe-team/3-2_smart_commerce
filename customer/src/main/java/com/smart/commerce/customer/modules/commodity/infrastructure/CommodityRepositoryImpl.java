package com.smart.commerce.customer.modules.commodity.infrastructure;

import com.smart.commerce.customer.modules.commodity.domain.Commodity;
import com.smart.commerce.customer.modules.commodity.domain.CommodityId;
import com.smart.commerce.customer.modules.commodity.domain.CommodityRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommodityRepositoryImpl implements CommodityRepository {
    private final EntityManager em;

    public CommodityRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Commodity save(Commodity commodity) {
        return null;
    }

    @Override
    public List<Commodity> findAll() {
        return List.of();
    }

    @Override
    public Optional<Commodity> findById(CommodityId id) {
        return Optional.empty();
    }
}
