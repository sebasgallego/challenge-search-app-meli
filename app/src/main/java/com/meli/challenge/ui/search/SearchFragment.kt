package com.meli.challenge.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.meli.challenge.databinding.FragmentSearchBinding

/**
 * Fragmento responsable de la funcionalidad de búsqueda.
 */
class SearchFragment : Fragment() {

    // Binding para acceder a las vistas del layout.
    private lateinit var binding: FragmentSearchBinding

    /**
     * Infla el layout y establece el binding.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar el layout usando el binding.
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Configura los listeners para los botones de búsqueda y limpieza.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    /**
     * Navega al fragmento de productos si el campo de búsqueda no está vacío.
     */
    fun gotoSearchProduct() {
        val nameProduct = binding.editTextSearch.text.toString()
        // Navegar al fragmento de productos con el nombre del producto.
        findNavController().navigate(
            SearchFragmentDirections.actionSearchFragmentToProductFragment(name = nameProduct)
        )
        /*if (nameProduct.isEmpty()) {
            // Mostrar mensaje de validación si el campo de búsqueda está vacío.
            Toast.makeText(context, getString(R.string.lbl_validate_text), Toast.LENGTH_SHORT).show()
        } else {
            // Navegar al fragmento de productos con el nombre del producto.
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToProductFragment(name = nameProduct)
            )
        }*/
    }

    /**
     * Configura los listeners para los botones de búsqueda y limpieza.
     */
    private fun setupListeners() {
        setupSearchClickListener()
        setupClearClickListener()
        setupSearchEditActionClickListener()
    }

    /**
     * Configura el listener para el botón de búsqueda.
     */
    fun setupSearchClickListener() {
        //Listener para el botón de búsqueda.
        binding.textViewSearch.setOnClickListener {
            gotoSearchProduct()
        }
    }

    /**
     * Configura el listener para el botón de acción de teclado.
     */
    fun setupSearchEditActionClickListener() {
        //listener para el botón de acción de teclado.
        binding.editTextSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                gotoSearchProduct()
            }
            false
        }
    }

    /**
     * Configura el listener para el botón de limpiar.
     * Limpia el texto del campo de búsqueda.
     */
    fun setupClearClickListener() {
        binding.imageViewClear.setOnClickListener {
            binding.editTextSearch.setText("")
        }
    }

}
