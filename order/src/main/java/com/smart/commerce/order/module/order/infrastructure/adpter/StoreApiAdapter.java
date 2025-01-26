package com.smart.commerce.order.module.order.infrastructure.adpter;


import com.smart.commerce.order.module.order.application.port.out.StoreStatusPort;
import com.smart.commerce.order.module.order.infrastructure.adpter.dto.StoreAssertStatusResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class StoreApiAdapter implements StoreStatusPort {

    private final RestClient restClient;

    @Value("${server.port:8080}") // 기본 포트 8080
    private int serverPort;

    public StoreApiAdapter() {
        this.restClient = RestClient.builder().build();;
    }

    @Override
    public Boolean getStoreOpenStatus(Long storeId) {
        ResponseEntity<StoreAssertStatusResponse> isOpened = restClient.get()
                .uri("http://localhost:{port}/store/status?storeId={storeId}", serverPort, storeId)
                .retrieve()
                .toEntity(StoreAssertStatusResponse.class);
        return isOpened.getBody().isOpened();
    }
}
