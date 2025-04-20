package dev.bozlak.envantertakip.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.Room
import dev.bozlak.envantertakip.dal.InventoryDatabase
import dev.bozlak.envantertakip.databinding.FragmentMainBinding
import dev.bozlak.envantertakip.entities.GeneralInventoryDate
import dev.bozlak.envantertakip.entities.products.Product
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MainFragment : Fragment() {
    private val mDisposable = CompositeDisposable()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var db : InventoryDatabase
    private var lastGeneralInventoryDate : String = ""
    private var products : List<Product>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(requireContext(),InventoryDatabase::class.java,"inventory_database")
            .build()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getLastGeneralInventoryDate()
        getProducts()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mDisposable.clear()
    }

    private fun getLastGeneralInventoryDate(){
        mDisposable.add(
            db.generalInventoryDateDao().getLastGeneralInventoryDate()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::setLastGeneralInventoryDate)
        )
    }

    private fun setLastGeneralInventoryDate(generalInventoryDate : GeneralInventoryDate){
        this.lastGeneralInventoryDate = generalInventoryDate.getDate()
    }

    private fun getProducts(){
        mDisposable.add(
            db.productDao().getAllProducts(this.lastGeneralInventoryDate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setProducts)
        )
    }

    private fun setProducts(products : List<Product>){
        this.products = products
    }
}