package com.smart.commerce.ceo.modules.commodity.api;

import com.smart.commerce.ceo.modules.commodity.api.dto.CommodityRegisterRequest;
import com.smart.commerce.ceo.modules.commodity.api.dto.CommodityResponse;
import com.smart.commerce.ceo.modules.commodity.api.dto.PriceChangeRequest;
import com.smart.commerce.ceo.modules.commodity.application.CommodityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/ceo/commodity")
@RestController
public class CommodityApi {
    private final CommodityService commodityService;

    public CommodityApi(final CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @PostMapping
    public ResponseEntity<Void> registerCommodity(@RequestBody CommodityRegisterRequest request) {
        commodityService.registerCommodity(request.name(), request.price());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{commodityId}/price")
    public ResponseEntity<Void> changePrice(@PathVariable String commodityId, @RequestBody PriceChangeRequest request){
        commodityService.changePrice(commodityId, request.price());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CommodityResponse>> getCommodityList(){
        return ResponseEntity.ok(commodityService.getCommodityList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommodityResponse> getCommodityById(@PathVariable UUID id){
        return ResponseEntity.ok(CommodityResponse.of(commodityService.getCommodity(id)));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCommodity(@RequestParam String commodityId){
        commodityService.deleteCommodity(commodityId);
        return ResponseEntity.ok().build();
    }
}
