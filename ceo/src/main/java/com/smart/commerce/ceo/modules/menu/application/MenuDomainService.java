//package com.smart.commerce.ceo.modules.menu.application;
//
//import com.smart.commerce.ceo.modules.commodity.api.CommodityApi;
//import com.smart.commerce.ceo.modules.commodity.api.dto.CommodityResponse;
//import com.smart.commerce.ceo.modules.commodity.application.CommodityService;
//import com.smart.commerce.ceo.modules.menu.domain.Menu;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MenuService {
////    private final CommodityService commodityService;
//    private final CommodityApi commodityApi;
//
//    public MenuDomainService(CommodityService commodityService) {
//        this.commodityService = commodityService;
//    }
//
//    public void validateMenuCommoditys(Menu menu){
//        menu.getCommoditys().forEach(commodityId -> {
//            CommodityResponse commodityResponse = commodityService.getCommodity(commodityId.getCommodityId().getValue());
//            if(commodityResponse != null){
//                throw new IllegalArgumentException("존재하지 않는 상품입니다.");
//            }
//        });
//    }
//}
