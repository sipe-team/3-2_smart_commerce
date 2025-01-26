package com.smart.commerce.ceo.modules.store.domain;

public interface StoreRepository {
    Store save(final Store store);

    Store findById(final Long storeId);

    Store findByIdAndCeoId(final Long storeId, final Long ceoId);
}
