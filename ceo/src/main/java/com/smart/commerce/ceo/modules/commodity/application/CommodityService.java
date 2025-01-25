package com.smart.commerce.ceo.modules.commodity.application;

import com.smart.commerce.ceo.modules.commodity.api.dto.CommodityResponse;
import com.smart.commerce.ceo.modules.commodity.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommodityService {
    private final CommodityRepository commodityRepository;

    public CommodityService(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    public void registerCommodity(String name, Integer price) { //TODO: 변수별로 할지, request 클래스를 받을 지
        CommodityName commodityName = new CommodityName(name);
        CommodityPrice commodityPrice = new CommodityPrice(price);
        CommodityId commodityId = CommodityId.generate();
        Commodity commodity = new Commodity(commodityId, commodityName, commodityPrice);
        // => 생성하는 아이. factory?!?!
//        Commodity commodity = new Commodity(name, price);

        commodityRepository.save(commodity);
    }

    public void changePrice(String commodityIdStr, Integer price) {
        CommodityId commodityId = new CommodityId(commodityIdStr);

        Commodity commodity = commodityRepository.findById(commodityId)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 상품입니다."));

        CommodityPrice newPrice = new CommodityPrice(price);

        commodity.changePrice(newPrice);

        commodityRepository.save(commodity);
    }


    public List<CommodityResponse> getCommodityList() {
        return commodityRepository.findAll()
                .stream()
                .map(commodity -> new CommodityResponse(
                        commodity.getId().getValue().toString(),
                        commodity.getName().getValue(),
                        commodity.getPrice().getValue()))
                .collect(Collectors.toList());
    }
}
