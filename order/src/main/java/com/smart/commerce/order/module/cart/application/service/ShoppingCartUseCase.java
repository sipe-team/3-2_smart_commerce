package com.smart.commerce.order.module.cart.application.service;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCartSnapshot;
import com.smart.commerce.order.module.cart.application.exception.NotFoundCartException;
import com.smart.commerce.order.module.cart.application.exception.NotFoundMenuException;
import com.smart.commerce.order.module.cart.domain.Menu;
import com.smart.commerce.order.module.cart.domain.MenuClient;
import com.smart.commerce.order.module.cart.domain.ShoppingCart;
import com.smart.commerce.order.module.cart.domain.ShoppingCartRepository;
import com.smart.commerce.order.module.order.application.port.out.ShoppingCartPort;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartUseCase implements ShoppingCartPort {

    private final ShoppingCartRepository cartRepository;
    private final MenuClient menuClient;

    public void add(Long customerId, Long menuId) {
        final Menu menu = getMenu(menuId);
        final ShoppingCart cart = cartRepository.findByCustomerId(customerId)
                .orElseGet(() -> new ShoppingCart(customerId, menu.storeId()));
        cart.add(menu);
        cartRepository.save(cart);
    }

    public void minus(Long userId, Long menuId) {
        final Menu menu = getMenu(menuId);
        final ShoppingCart cart = getCart(userId);
        cart.minus(menu);
        cartRepository.save(cart);
    }

    public void delete(Long userId, Long menuId) {
        final ShoppingCart cart = getCart(userId);
        cart.delete(menuId);
        cartRepository.save(cart);
    }

    private ShoppingCart getCart(final Long customerId) {
        return cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new NotFoundCartException(customerId));
    }

    private Menu getMenu(final Long menuId) {
        return menuClient.findById(menuId)
                .orElseThrow(() -> new NotFoundMenuException(menuId));
    }

    @Override
    public ShoppingCartSnapshot getItems(final Long customerId) {
        final ShoppingCart cart = getCart(customerId);
        final Map<Long, Menu> menus = createMap(menuClient.findAllById(cart.getMenuIds()));
        return new ShoppingCartSnapshot(cart.getStoreId(), cart.getAmount(menus));
    }

    private Map<Long, Menu> createMap(List<Menu> menus) {
        return menus.stream()
                .collect(Collectors.toMap(
                        Menu::menuId,
                        menu -> menu,
                        (existing, replacement) -> replacement
                ));
    }
}
