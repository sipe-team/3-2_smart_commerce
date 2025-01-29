package com.smart.commerce.ceo.modules.menu.domain;

import com.smart.commerce.ceo.modules.menu.infrastructure.MenuEntity;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {
    void save(Menu menu);
    Optional<Menu> findById(MenuId id);
    List<Menu> findByStoreId(Long storeId);
}
