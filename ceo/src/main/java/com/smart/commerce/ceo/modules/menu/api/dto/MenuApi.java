package com.smart.commerce.ceo.modules.menu.api.dto;

import com.smart.commerce.ceo.modules.menu.api.MenuResponse;
import com.smart.commerce.ceo.modules.menu.application.MenuListResponse;
import com.smart.commerce.ceo.modules.menu.application.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/ceo/menu")
@RestController
public class MenuApi {
    private final MenuService menuService;

    public MenuApi(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<Void> createMenu(@RequestBody MenuCreateRequest menuCreateRequest){
        menuService.createMenu(menuCreateRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<MenuResponse> getMenu(@PathVariable UUID id) {
        return ResponseEntity.ok(menuService.getMenu(id));
    }

    @PatchMapping("/{menuId}")
    public ResponseEntity<Void> changeMenu(@PathVariable UUID menuId, @RequestBody MenuUpdateRequest menuUpdateRequest){
        menuService.updateMenu(menuId, menuUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<MenuListResponse> getMenuList(@PathVariable Long storeId) {
        return ResponseEntity.ok(menuService.getMenuList(storeId));
    }
}
