package com.smart.commerce.modules.delivery.application;

import com.smart.commerce.modules.delivery.application.dto.PurchaseOrderCooked;
import com.smart.commerce.modules.delivery.application.dto.PurchaseOrderFinished;
import com.smart.commerce.modules.delivery.domain.DeliveryAssigned;
import com.smart.commerce.modules.delivery.domain.DeliveryFinished;
import com.smart.commerce.modules.delivery.domain.DeliveryStarted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DeliveryService {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryService.class);

    private final ApplicationEventPublisher applicationEventPublisher;

    public DeliveryService(final ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 준환이가 PurchaseOrderCooked 와 비슷한 이벤트 만들어주면 응답할 예정
     *
     * @param purchaseOrderCooked
     * @throws InterruptedException
     */
    @ApplicationModuleListener
    public void assignedDelivery(final PurchaseOrderCooked purchaseOrderCooked) throws InterruptedException {
        logger.info("배차 완료 이벤트 발생: {}", purchaseOrderCooked.orderNumber());
        Thread.sleep(new Random().nextInt(5000, 15000));
        applicationEventPublisher.publishEvent(new DeliveryAssigned(purchaseOrderCooked.orderNumber()));
    }

    /**
     * 준환이가 PurchaseOrderFinished 와 비슷한 이벤트 만들어주면 응답할 예정
     * @param purchaseOrderFinished
     * @throws InterruptedException
     */
    @ApplicationModuleListener
    public void startDelivery(final PurchaseOrderFinished purchaseOrderFinished) throws InterruptedException {
        Thread.sleep(new Random().nextInt(1000, 5000));
        applicationEventPublisher.publishEvent(new DeliveryStarted(purchaseOrderFinished.orderNumber()));
        Thread.sleep(new Random().nextInt(10000, 15000));
        applicationEventPublisher.publishEvent(new DeliveryFinished(purchaseOrderFinished.orderNumber()));
    }
}
