package com.smart.commerce.ceo.modules.menu.infrastructure;

import com.smart.commerce.ceo.modules.commodity.domain.Commodity;
import com.smart.commerce.ceo.modules.menu.domain.MenuCommodityRepository;
import org.springframework.stereotype.Component;

@Component
public class MenuCommodityRepositoryAdapter implements MenuCommodityRepository {
    @Override
    public Commodity findById(int id) {
        return null;
    }
}
