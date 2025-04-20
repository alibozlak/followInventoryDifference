package dev.bozlak.envantertakip.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "general_inventory_dates")
class GeneralInventoryDate {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "general_inventory_id")
    private var generalInventoryId : Int = 0

    @ColumnInfo(name = "date")
    private var date : String = ""

    fun getGeneralInventoryId() : Int{
        return generalInventoryId
    }

    fun setGeneralInventoryId(generalInventoryId : Int){
        this.generalInventoryId = generalInventoryId
    }

    fun getDate() : String{
        return date
    }

    fun setDate(date : String){
        this.date = date
    }

}