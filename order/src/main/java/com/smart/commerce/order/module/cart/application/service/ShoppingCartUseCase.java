package com.smart.commerce.order.module.cart.application.service;

import com.smart.commerce.order.module.cart.application.dto.ShoppingCartSnapshot;
import com.smart.commerce.order.module.cart.application.exception.NotFoundCartException;
import com.smart.commerce.order.module.cart.application.exception.NotFoundMenuException;
import com.smart.commerce.order.module.cart.domain.Menu;
import com.smart.commerce.order.module.cart.domain.MenuClient;
import com.smart.commerce.order.module.cart.domain.ShoppingCart;
import com.smart.commerce.order.module.cart.domain.ShoppingCartRepository;
import com.smart.commerce.order.module.order.application.port.out.ShoppingCartPort;
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

    public ShoppingCart findByCustomerId(final Long customerId) {
        return getCart(customerId);
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
    public ShoppingCartSnapshot getItems(
            final Long customerId) {
        return null;
    }
}
