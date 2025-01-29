package com.smart.commerce.ceo.modules.menu.domain;

import java.util.Optional;

public interface MenuGroupRepository {
    void save(MenuGroup menuGroup);
    Optional<MenuGroup> findById(MenuGroupId id);
    boolean existsById(MenuGroupId id);
}
