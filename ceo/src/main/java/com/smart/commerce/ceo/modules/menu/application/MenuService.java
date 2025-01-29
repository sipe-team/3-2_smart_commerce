package com.smart.commerce.ceo.modules.menu.application;

import com.smart.commerce.ceo.modules.commodity.application.CommodityQueryService;
import com.smart.commerce.ceo.modules.commodity.domain.CommodityId;
import com.smart.commerce.ceo.modules.menu.api.MenuResponse;
import com.smart.commerce.ceo.modules.menu.api.dto.MenuCreateRequest;
import com.smart.commerce.ceo.modules.menu.api.dto.MenuUpdateRequest;
import com.smart.commerce.ceo.modules.menu.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MenuService {
    private final CommodityQueryService commodityQueryService;
    private final MenuRepository menuRepository;
    private final MenuGroupRepository menuGroupRepository;

    public MenuService(CommodityQueryService commodityQueryService, MenuRepository menuRepository, MenuGroupRepository menuGroupRepository) {
        this.commodityQueryService = commodityQueryService;
        this.menuRepository = menuRepository;
        this.menuGroupRepository = menuGroupRepository;
    }

    public void createMenu(MenuCreateRequest menuCreateRequest) {
        MenuId menuId = MenuId.generate();
        MenuName menuName = new MenuName(menuCreateRequest.name());
        MenuPrice menuPrice = new MenuPrice(menuCreateRequest.price());
        MenuGroupId menuGroupId = new MenuGroupId(menuCreateRequest.menuGroupId());

        if(menuGroupRepository.existsById(menuGroupId)) throw new IllegalArgumentException("존재하지 않는 메뉴 그룹입니다.");

        Menu menu = new Menu(menuId, menuCreateRequest.storeId(), menuName, menuPrice, menuGroupId, true);

        validateCommodity(menuCreateRequest.commoditys(), menu.getPrice().getValue());
        menuCreateRequest.commoditys()
                .forEach(commodity ->  menu.addCommodity(new MenuCommodity(menuId, new CommodityId(commodity))));

        menuRepository.save(menu);
    }

    public MenuResponse getMenu(UUID id) {
        MenuId menuId = new MenuId(id);
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
        return MenuResponse.of(menu);
    }

    public void updateMenu(UUID id, MenuUpdateRequest menuUpdateRequest) {
        MenuId menuId = new MenuId(id);
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        if (menuUpdateRequest.name() != null) menu.changeName(menuUpdateRequest.name());

        if (menuUpdateRequest.menuGroupId() != null) menu.changeGroup(menuUpdateRequest.menuGroupId());

//        if(menuUpdateRequest.commoditys() != null){ //TODO: 상품 변경은 따로 뺄지, 여기에 넣을지는 추후에 하기
//            validateCommodity(commodityIds, menu.getPrice().getValue());
//
//        }

        if (menuUpdateRequest.price() != null){
            List<UUID> commodityIds = menu.getCommoditys().stream()
                    .map(menuCommodity -> menuCommodity.getCommodityId().getValue())
                    .toList();
            validateCommodity(commodityIds, menu.getPrice().getValue());
            menu.changePrice(menuUpdateRequest.price());
        }

        menuRepository.save(menu);
    }

    public MenuListResponse getMenuList(Long storeId){
        List<Menu> menuList = menuRepository.findByStoreId(storeId);
        return new MenuListResponse(menuList.stream().map(MenuResponse::of).toList());
    }

    private void validateCommodity(List<UUID> menuCommoditys, Integer menuPirce) {
        int totalPrice = 0;
        totalPrice += menuCommoditys.stream()
                .map(commodityQueryService::getCommodity)
                .mapToInt(id -> id.getPrice().getValue())
                .sum();

        if(menuPirce > totalPrice){
            throw new IllegalArgumentException("메뉴 가격은 상품 가격 합보다 비쌀 수 없습니다.");
        }
    }
}
