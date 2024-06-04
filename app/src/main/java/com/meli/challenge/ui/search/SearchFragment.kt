package com.meli.challenge.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.meli.challenge.R
import com.meli.challenge.databinding.FragmentSearchBinding

/**
 * Fragmento responsable de la funcionalidad de búsqueda.
 */
class SearchFragment : Fragment() {

    // Binding para acceder a las vistas del layout.
    private lateinit var binding: FragmentSearchBinding

    /**
     * Inflar el layout y establecer el binding.
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
     * Configurar los listeners para los botones de búsqueda y limpieza.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    /**
     * Configurar los listeners para los botones de búsqueda y limpieza.
     */
    private fun setupListeners() {
        setupSearchClickListener()
        setupClearClickListener()
    }

    /**
     * Configurar el listener para el botón de búsqueda.
     * Navega al fragmento de productos si la búsqueda no está vacía.
     */
    private fun setupSearchClickListener() {
        binding.textViewSearch.setOnClickListener {
            val nameProduct = binding.editTextSearch.text.toString()
            if (nameProduct.isEmpty()) {
                // Mostrar mensaje de validación si el campo de búsqueda está vacío.
                Toast.makeText(context, getString(R.string.lbl_validate_text), Toast.LENGTH_SHORT).show()
            } else {
                // Navegar al fragmento de productos con el nombre del producto.
                findNavController().navigate(
                    SearchFragmentDirections.actionSearchFragmentToProductFragment(name = nameProduct)
                )
            }
        }
    }

    /**
     * Configurar el listener para el botón de limpiar.
     * Limpia el texto del campo de búsqueda.
     */
    private fun setupClearClickListener() {
        binding.imageViewClear.setOnClickListener {
            binding.editTextSearch.setText("")
        }
    }
}
