package com.meli.challenge.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.meli.challenge.databinding.FragmentProductBinding
import com.meli.challenge.ui.product.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModels()
    private val args : ProductFragmentArgs by navArgs()
    private lateinit var binding: FragmentProductBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentProductBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        setupObservers()
        findProducts()
    }

    private fun findProducts(){
        val nameProduct = args.name
        viewModel.getProducts(nameProduct)
    }

    /**
     * Observe get list products
     */
    private fun setupObservers() {

        //Observe loading when get list products
        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }

        //Observe get list cats
        viewModel.productLiveData.observe(viewLifecycleOwner) { dataResponse ->
            if (dataResponse!!.size > 0) {
                adapter.newItems(ArrayList(dataResponse))
            }else{
                binding.layoutEmpty.isVisible = true
            }
        }
    }

    /**
     * init Recycler View
     */
    private fun initRecyclerView() {
        adapter = ProductAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = adapter
    }
}