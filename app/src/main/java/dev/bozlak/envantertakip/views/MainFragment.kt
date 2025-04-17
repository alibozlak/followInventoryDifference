package dev.bozlak.envantertakip.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.bozlak.envantertakip.business.abstracts.ProductAndEventService
import dev.bozlak.envantertakip.business.concretes.FirstProductAndEventManager
import dev.bozlak.envantertakip.databinding.FragmentMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MainFragment : Fragment() {
    private lateinit var productAndEventService : ProductAndEventService
    private lateinit var mDisposable : CompositeDisposable
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productAndEventService = FirstProductAndEventManager.getInstance()
        mDisposable = CompositeDisposable()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showSummaryInventoryDifferencePrice()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mDisposable.clear()
    }

    private fun showSummaryInventoryDifferencePrice(){
        mDisposable.add(
            productAndEventService.getSummaryInventoryDifferencePrice()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setInventoryDifferencePriceToTextView)
        )
    }

    private fun setInventoryDifferencePriceToTextView(inventoryDifferencePrice : Double){
        binding.textViewInventoryDifferencePrice.text = inventoryDifferencePrice.toString()
    }

}