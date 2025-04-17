package dev.bozlak.envantertakip.dal

import androidx.room.Dao
import androidx.room.Query
import dev.bozlak.envantertakip.entities.products.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun getAllProducts() : List<Product>?

}