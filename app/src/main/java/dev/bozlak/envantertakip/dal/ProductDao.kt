package dev.bozlak.envantertakip.dal

import androidx.room.Dao
import androidx.room.Query
import dev.bozlak.envantertakip.entities.products.ProductIdInventoryDifferenceAndDate

@Dao
interface ProductDao {
    @Query("SELECT product_id, inventory_difference, last_product_inventory_date_and_time FROM products")
    fun getAllProductIdInventoryDifferenceAndDate() : List<ProductIdInventoryDifferenceAndDate>
}