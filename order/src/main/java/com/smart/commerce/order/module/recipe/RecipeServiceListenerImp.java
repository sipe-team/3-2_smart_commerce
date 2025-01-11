package com.smart.commerce.order.module.recipe;

import com.smart.commerce.order.module.order.OrderToRecipeEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RecipeServiceListenerImp implements RecipeService {

    @EventListener
    public void onApplicationEvent(OrderToRecipeEvent event) {
        System.out.println(event.toString());
    }
}
