package dev.bozlak.envantertakip.entities.products

class ProductIdInventoryDifferenceAndDate {
    private var productId : UInt = 0u
    private var inventoryDifference : Double = 0.0
    private var lastProductInventoryDateAndTime : String? = null

    constructor(productId : UInt, inventoryDifference : Double, lastProductInventoryDateAndTime : String){
        this.productId = productId
        this.inventoryDifference = inventoryDifference
        this.lastProductInventoryDateAndTime = lastProductInventoryDateAndTime
    }

    public fun getProductId() : UInt {
        return this.productId
    }

    public fun getInventoryDifference() : Double {
        return this.inventoryDifference
    }

    public fun getLastProductInventoryDateAndTime() : String? {
        return this.lastProductInventoryDateAndTime
    }

    public fun setProductId(productId : UInt) {
        this.productId = productId
    }

    public fun setInventoryDifference(inventoryDifference : Double) {
        this.inventoryDifference = inventoryDifference
    }

    public fun setLastProductInventoryDateAndTime(lastProductInventoryDateAndTime : String) {
        this.lastProductInventoryDateAndTime = lastProductInventoryDateAndTime
    }

}