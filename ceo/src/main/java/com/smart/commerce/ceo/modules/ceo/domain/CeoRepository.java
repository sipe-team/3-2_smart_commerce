package com.smart.commerce.ceo.modules.ceo.domain;

public interface CeoRepository {
    Ceo save(final Ceo ceo);

    Ceo findByAccount(final String account);

    Ceo findById(final long ceoId);
}
