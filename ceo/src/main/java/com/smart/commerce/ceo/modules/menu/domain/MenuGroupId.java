package com.smart.commerce.ceo.modules.menu.domain;

import java.util.Objects;
import java.util.UUID;

public class MenuGroupId {
    private final UUID value;

    public MenuGroupId(UUID value) {
        this.value = value;
    }

    public static MenuGroupId generate(){
        return new MenuGroupId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuGroupId that = (MenuGroupId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
