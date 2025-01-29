package com.smart.commerce.ceo.modules.menu.api;

import com.smart.commerce.ceo.modules.menu.domain.Menu;

import java.util.UUID;

public record MenuResponse (
        UUID id,
        String menuName,
        Integer menuPrice
){
    public static MenuResponse of(Menu menu) {
        return new MenuResponse(menu.getId().getValue(), menu.getName().getValue(), menu.getPrice().getValue());
    }
}
