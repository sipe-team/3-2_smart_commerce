package com.smart.commerce.ceo.modules.menu.application;

import com.smart.commerce.ceo.modules.menu.api.MenuResponse;

import java.util.List;

public record MenuListResponse(
        List<MenuResponse> menuResponses
) {
}
