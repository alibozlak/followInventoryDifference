package dev.bozlak.envantertakip.business.abstracts

import io.reactivex.rxjava3.core.Flowable

interface ProductAndEventService {
    fun getSummaryInventoryDifferencePrice() : Flowable<Double>
}