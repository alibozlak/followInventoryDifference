package dev.bozlak.envantertakip.dal

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.bozlak.envantertakip.entities.GeneralInventoryDate
import dev.bozlak.envantertakip.entities.events.EventAffectingTheStore
import dev.bozlak.envantertakip.entities.events.negatives.NegativeEventForStore
import dev.bozlak.envantertakip.entities.events.positives.PositiveEventForStore
import dev.bozlak.envantertakip.entities.products.Product

@Database(
    entities = [Product::class,
                EventAffectingTheStore::class,
                GeneralInventoryDate::class,
                PositiveEventForStore::class,
                NegativeEventForStore::class],
    version = 1)
abstract class InventoryDatabase : RoomDatabase() {
    abstract fun productDao() : ProductDao
    abstract fun eventAffectingTheStoreDao() : EventAffectingTheStoreDao
    abstract fun generalInventoryDateDao() : GeneralInventoryDateDao
    abstract fun positiveEventDao() : PositiveEventDao
    abstract fun negativeEventDao() : NegativeEventDao

}