package dev.bozlak.envantertakip.entities.events

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events_affecting_the_store")
class EventAffectingTheStore {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "event_id")
    private var eventId : UInt = 0u

    @ColumnInfo(name = "product_id")
    private var productId : UInt = 0u

    /**
     * Can be negative or positive
     * Negative value : Negative event for store
     * Positive value : Positive event for store
     */
    @ColumnInfo(name = "amount")
    private var amount : Double = 0.0

    @ColumnInfo(name = "date")
    private var date : String? = null

    constructor(productId : UInt, amount : Double) {
        this.setProductId(productId)
        this.setAmount(amount)
    }

    constructor(productId : UInt, amount : Double, date : String)
            : this(productId, amount){
        this.date = date
    }

    fun setProductId(productId : UInt) {
        if (productId > 0u){
            this.productId = productId
        }
    }

    fun setAmount(amount : Double) {
        if (amount > 0.0){
            this.amount = amount
        }
    }

    fun getEventId() : UInt {
        return this.eventId
    }

    fun getProductId() : UInt {
        return this.productId
    }

    fun getAmount() : Double {
        return this.amount
    }
}