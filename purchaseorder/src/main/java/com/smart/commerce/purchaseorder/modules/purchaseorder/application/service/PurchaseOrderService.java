package com.smart.commerce.purchaseorder.modules.purchaseorder.application.service;

import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder.PurchaseOrderInitialCommand;
import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder.PurchaseOrderStatusChangedCommand;
import com.smart.commerce.purchaseorder.modules.purchaseorder.application.command.purchaseorder.PurchaseOrderStockChangedCommand;
import com.smart.commerce.purchaseorder.modules.purchaseorder.application.handler.StatusHandler;
import com.smart.commerce.purchaseorder.modules.purchaseorder.application.usecase.PurchaseOrderAcceptUseCase;
import com.smart.commerce.purchaseorder.modules.purchaseorder.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PurchaseOrderService implements PurchaseOrderAcceptUseCase {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderService.class);

    private final ApplicationEventPublisher applicationEventPublisher;
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderHistoryRepository purchaseOrderHistoryRepository;
    private final StatusHandlerRegistry statusHandlerRegistry;

    public PurchaseOrderService(ApplicationEventPublisher applicationEventPublisher,
                                PurchaseOrderRepository purchaseOrderRepository,
                                PurchaseOrderHistoryRepository purchaseOrderHistoryRepository,
                                StatusHandlerRegistry statusHandlerRegistry) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.purchaseOrderHistoryRepository = purchaseOrderHistoryRepository;
        this.statusHandlerRegistry = statusHandlerRegistry;
    }

    // 주문 요청 수락 및 거절
    @Override
    @ApplicationModuleListener
    public PurchaseOrder processOrderRequest(
            final PurchaseOrderInitialCommand acceptCommand
    ) {
        // TODO 재고 차감 BUT. 전체 실패시 복구
//        applicationEventPublisher.publishEvent();

        // 주문서(수락, 거절) 생성
        PurchaseOrder purchaseOrder = purchaseOrderRepository.save(
                initializePurchaseOrder(acceptCommand)
        );

        // 상태 이력 저장
        purchaseOrderHistoryRepository.save(
                PurchaseOrderHistory.initialize(
                        purchaseOrder.getId(),
                        acceptCommand.status(),
                        acceptCommand.modifiedBy()
                )
        );

        return purchaseOrder;
    }

    // 주문서 상태 변경
    @Override
    @ApplicationModuleListener
    @Transactional
    public PurchaseOrder updateStatus(
            final PurchaseOrderStatusChangedCommand changedCommand
    ) {
        final PurchaseOrderStatusChangedCommand statusChangedCommand
                = changedCommand.withStatus(changedCommand.status().getNextStatus());

        // 상태에 따른 후속 작업 handler로 분리
        StatusHandler handler = statusHandlerRegistry.getHandler(statusChangedCommand.status());
        handler.handle(statusChangedCommand);

        // 상태 이력 저장
        purchaseOrderHistoryRepository.save(
                PurchaseOrderHistory.initialize(
                        statusChangedCommand.id(),
                        statusChangedCommand.status(),
                        statusChangedCommand.modifiedBy()
                )
        );

        return purchaseOrderRepository.updateStatus(
                initializePurchaseOrder(statusChangedCommand)
        );
    }

    // 재고 변경
    @ApplicationModuleListener
    public PurchaseOrder updateStock(
            final PurchaseOrderStockChangedCommand changedCommand
    ) {
        return new PurchaseOrder();
//        return purchaseOrderRepository.updateStatus(
//                initializePurchaseOrder(changedCommand)
//        );
    }

    // 라이더
    @ApplicationModuleListener
    public PurchaseOrder requestRiderAssignment(
            final PurchaseOrderStatusChangedCommand changedCommand
    ) {
        return purchaseOrderRepository.updateStatus(
                initializePurchaseOrder(changedCommand)
        );
    }

    private PurchaseOrder initializePurchaseOrder(final PurchaseOrderInitialCommand command) {
        return PurchaseOrder.initialize(
                command.userId(),
                command.storeId(),
                command.status(),
                command.modifiedBy()
        );
    }

    private PurchaseOrder initializePurchaseOrder(final PurchaseOrderStatusChangedCommand command) {
        return new PurchaseOrder(
                command.id(),
                command.status(),
                command.modifiedBy()
        );
    }
}
