package com.smart.commerce.ceo.modules.menu.domain;

import com.smart.commerce.ceo.modules.commodity.domain.CommodityId;

import java.util.Objects;

public class MenuCommodity {
    private final MenuId menuId;
    private final CommodityId commodityId;

    public MenuCommodity(MenuId menuId, CommodityId commodityId) {
        this.menuId = menuId;
        this.commodityId = commodityId;
    }

    public MenuId getMenuId() {
        return menuId;
    }

    public CommodityId getCommodityId() {
        return commodityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuCommodity that = (MenuCommodity) o;
        return Objects.equals(menuId, that.menuId) && Objects.equals(commodityId, that.commodityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, commodityId);
    }
}
