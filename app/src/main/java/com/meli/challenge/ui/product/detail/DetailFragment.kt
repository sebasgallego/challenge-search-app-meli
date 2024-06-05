package com.meli.challenge.ui.product.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.meli.challenge.databinding.FragmentDetailBinding

/**
 * Fragmento que muestra los detalles de un producto.
 */
class DetailFragment : Fragment() {

    // Binding para acceder a las vistas del layout.
    private lateinit var binding: FragmentDetailBinding
    // Args para obtener los argumentos de navegación.
    private val args: DetailFragmentArgs by navArgs()

    /**
     * Inflar el layout y establecer el binding.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar el layout usando el binding.
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Configurar el binding después de que la vista ha sido creada.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            // Establecer el ciclo de vida del propietario del binding.
            lifecycleOwner = viewLifecycleOwner
            // Asignar el producto recibido a la variable del layout.
            product = args.product
        }
    }

}
