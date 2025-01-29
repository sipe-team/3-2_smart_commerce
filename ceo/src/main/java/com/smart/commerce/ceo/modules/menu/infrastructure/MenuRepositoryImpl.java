package com.smart.commerce.ceo.modules.menu.infrastructure;

import com.smart.commerce.ceo.modules.commodity.application.CommodityQueryService;
import com.smart.commerce.ceo.modules.commodity.domain.Commodity;
import com.smart.commerce.ceo.modules.commodity.infrastructure.CommodityEntity;
import com.smart.commerce.ceo.modules.menu.domain.Menu;
import com.smart.commerce.ceo.modules.menu.domain.MenuId;
import com.smart.commerce.ceo.modules.menu.domain.MenuRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class MenuRepositoryImpl implements MenuRepository {
    private final MenuEntityRepository menuEntityRepository;
    private final CommodityQueryService commodityQueryService;

    public MenuRepositoryImpl(MenuEntityRepository menuEntityRepository, CommodityQueryService commodityQueryService) {
        this.menuEntityRepository = menuEntityRepository;
        this.commodityQueryService = commodityQueryService;
    }

    @Override
    public void save(Menu menu) {
        MenuEntity menuEntity = toEntity(menu);
        menuEntityRepository.save(menuEntity);
    }

    @Override
    public Optional<Menu> findById(MenuId id) {
        return Optional.of(menuEntityRepository.findById(id.getValue())
                .map(MenuEntity::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다.")));
    }

    @Override
    public List<Menu> findByStoreId(Long storeId) {
        return menuEntityRepository.findByStoreId(storeId)
                .stream()
                .map(MenuEntity::toDomain)
                .collect(Collectors.toList());
    }

    private MenuEntity toEntity(Menu menu) {
        MenuEntity menuEntity = new MenuEntity(menu.getId(), menu.getStoreId(), menu.getName(), menu.getPrice(), menu.getMenuGropId(), menu.isVisible());

        Set<CommodityEntity> commodities = menu.getCommoditys().stream()
                .map(commodity -> commodityQueryService.getCommodity(commodity.getCommodityId().getValue()))
                .map(Commodity::toEntity)
                .collect(Collectors.toSet());

        menuEntity.setCommoditys(commodities);

        return menuEntity;
    }
}
