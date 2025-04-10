package dev.bozlak.envantertakip.entities.events.negatives

enum class NegativeEventType {
    CASHIER_WRONG,
    COUNTING_WRONG_LATEST_INVENTORY,
    CHECK_WRONG_FROM_REPOSITORY,
    CHECK_WRONG_DIRECT_PRODUCT,
    CH_WRONG,
    STOLEN_PRODUCT,
    CUSTOMER_WRONG,
    OTHER
}