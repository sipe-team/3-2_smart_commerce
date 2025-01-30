package com.smart.commerce.ceo.modules.menu.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MenuUpdateRequest(
        String name,
        Integer price,
        UUID menuGroupId,
        List<UUID> commoditys
){
}
