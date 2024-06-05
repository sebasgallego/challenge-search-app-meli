package com.meli.challenge.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.meli.challenge.data.model.Product
import com.meli.challenge.databinding.FragmentProductBinding
import com.meli.challenge.ui.product.adapter.ProductAdapter
import com.meli.challenge.utils.ViewHelper
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragmento que muestra una lista de productos.
 */
@AndroidEntryPoint
class ProductFragment : Fragment(), ProductAdapter.ProductItemListener {

    // ViewModel para el fragmento
    private val productViewModel: ProductViewModel by viewModels()
    // Argumentos de navegación
    private val args: ProductFragmentArgs by navArgs()
    // Binding para acceder a las vistas del layout
    private lateinit var binding: FragmentProductBinding
    // Adaptador para la lista de productos
    private lateinit var adapter: ProductAdapter

    /**
     * Inflar el layout y establecer el binding.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Configurar las vistas y los observadores después de que la vista ha sido creada.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        setupObservers()
        findProducts()
        setupRetryButton()
    }

    /**
     * Buscar productos si aún no se ha realizado una búsqueda exitosa.
     */
    private fun findProducts() {
        if (!productViewModel.isSuccess) {
            val nameProduct = args.name
            productViewModel.getProducts(nameProduct)
        }
    }

    /**
     * Configurar los observadores para LiveData.
     */
    private fun setupObservers() {
        productViewModel.loading.observe(viewLifecycleOwner) { isVisible ->
            binding.progressBar.isVisible = isVisible
        }

        productViewModel.productLiveData.observe(viewLifecycleOwner) { dataResponse ->
            if (!dataResponse.isNullOrEmpty()) {
                adapter.newItems(ArrayList(dataResponse))
                binding.layoutRetry.isVisible = false
                binding.layoutEmpty.isVisible = false
            } else {
                binding.layoutEmpty.isVisible = true
                binding.layoutRetry.isVisible = false
            }
        }

        productViewModel.errorCode.observe(viewLifecycleOwner) { responseCode ->
            responseCode?.let {
                val errorMessage = ViewHelper(requireActivity()).processMsgError(it)
                binding.layoutRetry.isVisible = true
                binding.textViewRetry.text = errorMessage
                binding.layoutEmpty.isVisible = false
            }
        }
    }

    /**
     * Inicializar el RecyclerView y su adaptador.
     */
    private fun initRecyclerView() {
        adapter = ProductAdapter(this)
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = adapter
    }

    /**
     * Configurar el botón de reintentar búsqueda.
     */
    private fun setupRetryButton() {
        binding.textViewActionRetry.setOnClickListener {
            findProducts()
        }
    }

    /**
     * Navegar al fragmento de detalles del producto.
     *
     * @param product El producto seleccionado.
     */
    private fun goToNextScreen(product: Product) {
        val action = ProductFragmentDirections.actionProductFragmentToDetailFragment(product)
        findNavController().navigate(action)
    }

    /**
     * Método de callback cuando se selecciona un producto de la lista.
     *
     * @param product El producto seleccionado.
     */
    override fun onClickedProduct(product: Product) {
        goToNextScreen(product)
    }
}
