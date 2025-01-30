package com.smart.commerce.ceo.modules.menu.infrastructure;

import com.smart.commerce.ceo.modules.menu.domain.MenuGroup;
import com.smart.commerce.ceo.modules.menu.domain.MenuGroupId;
import com.smart.commerce.ceo.modules.menu.domain.MenuGroupName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "menu_group")
public class MenuGroupEntity {
    @Id
    private UUID id;
    private String name;

    public MenuGroupEntity() {}

    public MenuGroupEntity(MenuGroupId menuGroupId, MenuGroupName menuGroupName) {
        this.id = menuGroupId.getValue();
        this.name = menuGroupName.getValue();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String setName(MenuGroupName newName){
        return this.name = newName.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuGroupEntity that = (MenuGroupEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public MenuGroup toDomain() {
        return new MenuGroup(this.id, this.name);
    }
}
