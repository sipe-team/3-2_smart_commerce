package com.smart.commerce.ceo.modules.menu.domain;

import java.util.Objects;
import java.util.UUID;

public class MenuId {
    private final UUID value;

    public MenuId(UUID value) {
        this.value = value;
    }

    public static MenuId generate() {
        return new MenuId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuId menuId = (MenuId) o;
        return Objects.equals(value, menuId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
