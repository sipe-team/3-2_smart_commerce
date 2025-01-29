package com.smart.commerce.ceo.modules.menu.infrastructure;

import com.smart.commerce.ceo.modules.menu.domain.MenuGroup;
import com.smart.commerce.ceo.modules.menu.domain.MenuGroupId;
import com.smart.commerce.ceo.modules.menu.domain.MenuGroupRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MenuGroupRepositoryImpl implements MenuGroupRepository {
    private final MenuGroupEntityRepository menuGroupEntityRepository;

    public MenuGroupRepositoryImpl(MenuGroupEntityRepository menuGroupEntityRepository) {
        this.menuGroupEntityRepository = menuGroupEntityRepository;
    }

    @Override
    public void save(MenuGroup menuGroup) {
        MenuGroupEntity menuGroupEntity = new MenuGroupEntity(menuGroup.getId(), menuGroup.getName());
        menuGroupEntityRepository.save(menuGroupEntity);
    }

    @Override
    public Optional<MenuGroup> findById(MenuGroupId id) {
        return Optional.ofNullable(menuGroupEntityRepository.findById(id.getValue())
                .map(MenuGroupEntity::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴 그룹입니다.")));
    }

    @Override
    public boolean existsById(MenuGroupId id) {
        return menuGroupEntityRepository.existsById(id.getValue());
    }
}
