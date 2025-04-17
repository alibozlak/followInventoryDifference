package dev.bozlak.envantertakip.business.concretes;

import android.app.Application;

import androidx.room.Room;

import java.util.List;

import dev.bozlak.envantertakip.business.abstracts.ProductAndEventService;
import dev.bozlak.envantertakip.dal.EventAffectingTheStoreDao;
import dev.bozlak.envantertakip.dal.InventoryDatabase;
import dev.bozlak.envantertakip.dal.ProductDao;
import dev.bozlak.envantertakip.entities.products.Product;
import io.reactivex.rxjava3.core.Flowable;

public class FirstProductAndEventManager extends Application implements ProductAndEventService {
    private static FirstProductAndEventManager productAndEventManager;
    private final ProductDao productDao;
    private final EventAffectingTheStoreDao eventAffectingTheStoreDao;

    private FirstProductAndEventManager(){
        InventoryDatabase inventoryDatabase =
                Room.databaseBuilder(getApplicationContext(), InventoryDatabase.class, "inventory_database")
                .build();
        productDao = inventoryDatabase.productDao();
        eventAffectingTheStoreDao = inventoryDatabase.eventAffectingTheStoreDao();
    }

    public static FirstProductAndEventManager getInstance(){
        if(productAndEventManager == null){
            productAndEventManager = new FirstProductAndEventManager();
        }
        return productAndEventManager;
    }

    @Override
    public Flowable<Double> getSummaryInventoryDifferencePrice() {
        List<Product> productList = productDao.getAllProducts();
        Double summaryInventoryDifferencePrice = 0.0;
        if(productList != null){
            for(Product product : productList){
                int productId = product.getProductId();
                Double lastProductInventoryDifference = product.getInventoryDifference();
                String lastProductInventoryDateAndTime = product.getLastInventoryDateAndTime();
                Double currentPrice = product.getCurrentPrice();
                Byte tax = product.getTax();
                Double productInventoryDifference  = 0.0;
                Double productInventoryPrice = 0.0;

                if(
                        lastProductInventoryDifference != null
                        && lastProductInventoryDateAndTime != null
                ){
                    Double productEventDifference = eventAffectingTheStoreDao
                            .getTotalAmountOfGivenProductId(productId, lastProductInventoryDateAndTime);

                    if(productEventDifference != null){
                        productInventoryDifference = lastProductInventoryDifference + productEventDifference;
                    } else {
                        productInventoryDifference = lastProductInventoryDifference;
                    }
                }
                if(currentPrice != null){
                    if(tax != null){
                        productInventoryPrice = currentPrice * (1 - ((double)tax / 100));
                    } else {
                        productInventoryPrice = currentPrice;
                    }
                }

                Double productInventoryDifferencePrice = productInventoryDifference * productInventoryPrice;
                summaryInventoryDifferencePrice += productInventoryDifferencePrice;
            }
        }

        return Flowable.just(summaryInventoryDifferencePrice);
    }
}
