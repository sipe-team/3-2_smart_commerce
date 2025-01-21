package com.smart.commerce.order.module.order.application.dto;

// TODO menu 목록은 cart에 저장된 정보로 가져올지 바로 요청을 받을지
public record OrderRequest(long userId, long storeId) {
}
