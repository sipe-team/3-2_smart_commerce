package com.smart.commerce.ceo.modules.menu.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Menu {
    private final MenuId id;
    private final Long storeId;
    private MenuName name;
    private MenuPrice price;
    private boolean visible;
    private MenuGroupId menuGroupId;
    private Set<MenuCommodity> commoditys = new HashSet<>(); //TODO: id를 저장할지, domain자체를 저장할지 고민

    public Menu(MenuId id, Long storeId, MenuName name, MenuPrice price, MenuGroupId menuGroupId, boolean visible) {
        this.id = id;
        this.storeId = storeId;
        this.name = name;
        this.price = price;
        this.menuGroupId = menuGroupId;
        this.visible = visible;
    }

    public Menu(UUID id, Long storeId, String name, int price, UUID menuGroupId, boolean visible) {
        this.id = new MenuId(id);
        this.storeId = storeId;
        this.name = new MenuName(name);
        this.price = new MenuPrice(price);
        this.menuGroupId = new MenuGroupId(menuGroupId);
    }

    public MenuId getId() {
        return id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public MenuName getName() {
        return name;
    }

    public MenuPrice getPrice() {
        return price;
    }

    public boolean isVisible() {
        return visible;
    }

    public MenuGroupId getMenuGropId() {
        return menuGroupId;
    }

    public Set<MenuCommodity> getCommoditys() {
        return commoditys;
    }

    public void hide(){
        visible = false;
    }

    public void show(){
        visible = true;
    }

    public void changeName(String newName){
        this.name = new MenuName(newName);
    }

    public void changePrice(Integer newPrice){
        this.price = new MenuPrice(newPrice);
    }

    public void changeGroup(UUID menuGroupId) {
        this.menuGroupId = new MenuGroupId(menuGroupId);
    }

    public void addCommodity(MenuCommodity commodityId){
        this.commoditys.add(commodityId);
    }

    public void removeCommodity(MenuCommodity commodityId){
        this.commoditys.remove(commodityId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return visible == menu.visible && Objects.equals(id, menu.id) && Objects.equals(name, menu.name) && Objects.equals(price, menu.price) && Objects.equals(menuGroupId, menu.menuGroupId) && Objects.equals(commoditys, menu.commoditys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, visible, menuGroupId, commoditys);
    }


}
