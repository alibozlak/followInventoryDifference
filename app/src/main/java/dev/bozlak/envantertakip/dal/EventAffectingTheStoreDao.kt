package dev.bozlak.envantertakip.dal

import androidx.room.Dao
import androidx.room.Query

@Dao
interface EventAffectingTheStoreDao {
    @Query("SELECT SUM(amount) FROM events_affecting_the_store " +
            "WHERE product_id = :productId AND date >= :lastProductInventoryDateAndTime")
    fun getTotalAmountOfGivenProductId(productId : UInt, lastProductInventoryDateAndTime : String) : Double
}