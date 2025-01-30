package com.smart.commerce.ceo.modules.menu.infrastructure;

import com.smart.commerce.ceo.modules.commodity.infrastructure.CommodityEntity;
import com.smart.commerce.ceo.modules.menu.domain.*;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "menu")
public class MenuEntity {
    @Id
    private UUID id;
//    @ManyToOne
//    @JoinColumn(name="storeId")
//    private StoreEntity store;
    private Long storeId;
    private String name;
    private int price;
    private boolean visible;
    private UUID menuGroupId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "commoditys")
    private Set<CommodityEntity> commoditys = new HashSet<>();

    public MenuEntity() {}

    public MenuEntity(MenuId id, Long storeId, MenuName name, MenuPrice price, MenuGroupId groupId, boolean visible) {
        this.id = id.getValue();
        this.storeId = storeId;
        this.name = name.getValue();
        this.price = price.getValue();
        this.menuGroupId = groupId.getValue();
        this.visible = visible;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isVisible() {
        return visible;
    }

    public UUID getMenuGroupId() {
        return menuGroupId;
    }

    public Set<CommodityEntity> getCommoditys() {
        return commoditys;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCommoditys(Set<CommodityEntity> commoditys) {
        this.commoditys = commoditys;
    }

    public Menu toDomain(){
        return new Menu(id, storeId, name, price, menuGroupId, visible);
    }
}
