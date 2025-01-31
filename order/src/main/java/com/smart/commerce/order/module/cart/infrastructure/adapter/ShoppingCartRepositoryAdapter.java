package com.smart.commerce.order.module.cart.infrastructure.adapter;

import com.smart.commerce.order.module.cart.domain.ShoppingCart;
import com.smart.commerce.order.module.cart.domain.ShoppingCartRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShoppingCartRepositoryAdapter implements ShoppingCartRepository {

    public static final String PREFIX_KEY = "order:shopping-cart::";
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public Optional<ShoppingCart> findByCustomerId(final Long customerId) {
        final Object value = redisTemplate.opsForValue().get(createKey(customerId));
        if(value == null){
            return Optional.empty();
        }
        return Optional.of((ShoppingCart) value);
    }

    @Override
    public void save(final ShoppingCart cart) {
        redisTemplate.opsForValue().set(createKey(cart.getCustomerId()), cart);
    }

    private String createKey(Long customerId) {
        return PREFIX_KEY + customerId;
    }
}
