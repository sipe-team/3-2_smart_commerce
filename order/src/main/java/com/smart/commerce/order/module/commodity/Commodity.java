package com.smart.commerce.order.module.commodity;

import org.jmolecules.ddd.annotation.ValueObject;

import java.util.List;

// 상품(조리후)이냐 재고(조리전)냐 명확하지 않다 -> menu 는 세트메뉴 인거냐
// 만약에 치킨
@ValueObject
public record Commodity(String name, double price, int StoreId) {}
