package dev.bozlak.envantertakip.dal

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.bozlak.envantertakip.entities.products.Product

@Database(entities = [Product::class,], version = 1)
abstract class InventoryDatabase : RoomDatabase() {
    abstract fun productDao() : ProductDao
}