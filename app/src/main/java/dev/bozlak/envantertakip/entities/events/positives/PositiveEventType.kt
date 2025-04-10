package dev.bozlak.envantertakip.entities.events.positives

enum class PositiveEventType {
    CASHIER_WRONG,
    COUNTING_WRONG_LATEST_INVENTORY,
    CHECK_WRONG_FROM_REPOSITORY,
    CHECK_WRONG_DIRECT_PRODUCT,
    CH_WRONG,
    PAY_PRODUCT_BY_THIEF,
    CUSTOMER_WRONG,
    OTHER
}