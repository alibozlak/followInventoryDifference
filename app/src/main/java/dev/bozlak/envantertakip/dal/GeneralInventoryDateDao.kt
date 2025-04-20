package dev.bozlak.envantertakip.dal

import androidx.room.Dao
import androidx.room.Query
import dev.bozlak.envantertakip.entities.GeneralInventoryDate
import io.reactivex.rxjava3.core.Flowable

@Dao
interface GeneralInventoryDateDao {

    @Query("SELECT * FROM general_inventory_dates ORDER BY general_inventory_id DESC LIMIT 1")
    fun getLastGeneralInventoryDate() : Flowable<GeneralInventoryDate>

}