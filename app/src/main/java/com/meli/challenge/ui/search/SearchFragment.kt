package com.meli.challenge.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.meli.challenge.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentSearchBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickSearch()
    }

    private fun onClickSearch() {
        binding.textViewSearch.setOnClickListener {
            val nameProduct = binding.editTextSearch.text.toString()
            if (nameProduct.isEmpty()) {
                Toast.makeText(context, "Debe ingresar un nombre valido", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(
                    SearchFragmentDirections.actionSearchFragmentToProductFragment(name=nameProduct)
                )
            }
        }
    }

}