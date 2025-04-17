package dev.bozlak.envantertakip.entities.products

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.bozlak.envantertakip.utilities.ProductUtil

@Entity(tableName = "products")
public class Product(
    @ColumnInfo(name = "product_code")
    private var productCode : String?,

    @ColumnInfo(name = "product_name")
    private var productName : String?,

    @ColumnInfo(name = "sales_unit_type")
    private var salesUnitType: SalesUnitType?,

    @ColumnInfo(name = "current_price")
    private var currentPrice : Double?,

    @ColumnInfo(name = "tax")
    private var tax : Byte?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id")
    private var productId : Int = 0

    @ColumnInfo(name = "inventory_difference")
    private var inventoryDifference : Double? = 0.0

    @ColumnInfo(name = "last_product_inventory_date_and_time")
    private var lastProductInventoryDateAndTime : String? = null

    @ColumnInfo(name = "description")
    private var description : String? = null

    init {
        if (productCode != null && !setProductCode(productCode!!)){
            throw Exception("Please check your given product code!!")
        }
        if (currentPrice != null && currentPrice!! < 0){
            throw Exception("Please check your given current price! It must greater than 0!!")
        }
        if(tax != null && tax!! > 100){
            throw Exception("Please check your given tax! It must smaller than 100!!")
        }
        if(tax != null && tax!! < 0){
            throw Exception("Please check your given tax! It must greater than 0!!")
        }
    }

    constructor(
        productCode: String, productName: String, tax : Byte,
        salesUnitType: SalesUnitType, currentPrice: Double, inventoryDifference : Double )
            : this(productCode, productName, salesUnitType, currentPrice, tax){
                this.inventoryDifference = inventoryDifference
    }

    fun getInventoryDifference() : Double? {return this.inventoryDifference}

    fun getProductId() : Int {return this.productId}

    fun getLastInventoryDateAndTime() : String? {return this.lastProductInventoryDateAndTime}

    fun getCurrentPrice() : Double? {return this.currentPrice}

    fun getTax() : Byte? {return this.tax}

    fun setProductCode(productCode : String) : Boolean {
        val productCodeTrim = productCode.trim()
        if (ProductUtil.isProductCodeValid(productCodeTrim)){
            this.productCode = productCodeTrim
            return true
        }
        return false
    }
}