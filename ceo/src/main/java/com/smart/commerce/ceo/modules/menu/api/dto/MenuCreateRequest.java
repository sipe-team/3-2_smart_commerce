package com.smart.commerce.ceo.modules.menu.api.dto;

import java.util.List;
import java.util.UUID;

public record MenuCreateRequest(
        Long storeId,
        String name,
        Integer price,
        UUID menuGroupId,
        List<UUID> commoditys
) {
}
