package com.meli.challenge.ui.product.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.meli.challenge.data.model.Product
import com.meli.challenge.databinding.ListItemProductBinding
import com.meli.challenge.utils.NumberHelper

/**
 * ViewHolder para un elemento de la lista de productos.
 *
 * @param itemBinding El binding de datos para el elemento de la lista.
 */
class ProductViewHolder(
    private val itemBinding: ListItemProductBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    // Variable para almacenar el producto asociado a este ViewHolder.
    private lateinit var product: Product

    /**
     * Vincula los datos del producto con las vistas del ViewHolder.
     *
     * @param item El producto a mostrar.
     */
    fun bind(item: Product) {
        this.product = item

        // Cargar la imagen del producto usando Glide.
        Glide.with(itemBinding.root)
            .load(item.thumbnail)
            .centerInside()
            .into(itemBinding.imageViewProduct)

        // Establecer el título del producto, limitado a 60 caracteres.
        itemBinding.textViewTitle.text = item.title.take(60)

        // Establecer el precio del producto, formateado como moneda COP.
        itemBinding.textViewPrice.text = "$ ${NumberHelper().parseAmountToCOP(item.price)}"

        // Si hay información sobre las cuotas, mostrar el texto de las cuotas.
        if (item.installments != null) {
            itemBinding.textViewInstallments.text =
                "${item.installments!!.quantity}x $${NumberHelper().parseAmountToCOP(item.installments!!.amount)}"
        }

        // Establecer la cantidad disponible del producto.
        itemBinding.textViewQuantity.text = "${item.availableQuantity}"
    }
}
