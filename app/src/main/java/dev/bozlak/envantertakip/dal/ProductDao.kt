package dev.bozlak.envantertakip.dal

import androidx.room.Dao
import androidx.room.Query
import dev.bozlak.envantertakip.entities.products.Product
import io.reactivex.rxjava3.core.Flowable

@Dao
interface ProductDao {
    @Query("SELECT * FROM products WHERE last_product_inventory_date_and_time >= :lastInventoryDate")
    fun getAllProducts(lastInventoryDate : String) : Flowable<List<Product>>

}