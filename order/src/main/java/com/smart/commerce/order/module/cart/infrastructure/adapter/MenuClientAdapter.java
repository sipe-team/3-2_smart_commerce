package com.smart.commerce.order.module.cart.infrastructure.adapter;

import com.smart.commerce.order.module.cart.domain.Menu;
import com.smart.commerce.order.module.cart.domain.MenuClient;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class MenuClientAdapter implements MenuClient {

    @Override
    public Optional<Menu> findById(final Long id) {
        return Optional.of(getMenu(id));
    }

    @Override
    public List<Menu> findAllById(final List<Long> menuIds) {
        return getMenus(menuIds);
    }

    private List<Menu> getMenus(List<Long> ids) {
        return ids.stream()
                .map(this::getMenu)
                .toList();
    }

    private Menu getMenu(Long id) {
        return new Menu(id, 1L, "테스트 메뉴", 1000);
    }
}
