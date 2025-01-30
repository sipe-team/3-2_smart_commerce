package com.smart.commerce.ceo.modules.menu.domain;

import java.util.Objects;
import java.util.UUID;

public class MenuGroup {
    private final MenuGroupId id;
    private MenuGroupName name;

    public MenuGroup(UUID id, String name) {
        this.id = new MenuGroupId(id);
        this.name = new MenuGroupName(name);
    }

    public MenuGroupId getId() {
        return id;
    }

    public MenuGroupName getName() {
        return name;
    }

    public void changeName(String newName) {
        this.name = new MenuGroupName(newName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuGroup menuGroup = (MenuGroup) o;
        return Objects.equals(id, menuGroup.id) && Objects.equals(name, menuGroup.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
