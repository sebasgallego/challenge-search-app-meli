package com.meli.challenge.ui.product.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.meli.challenge.data.model.Product
import com.meli.challenge.databinding.ListItemProductBinding
import com.meli.challenge.utils.NumberHelper

/**
 * ViewHolder para un elemento de la lista de productos.
 * Este ViewHolder se utiliza para mostrar un producto individual en un RecyclerView.
 *
 * @param itemBinding El binding de datos para el elemento de la lista.
 * @param listener Interfaz para manejar los clicks en los elementos de la lista.
 */
class ProductViewHolder(
    private val itemBinding: ListItemProductBinding,
    private val listener: ProductAdapter.ProductItemListener
) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {
    private lateinit var product: Product

    // Inicializador, configura el OnClickListener en la vista raíz del layout.
    init {
        itemBinding.root.setOnClickListener(this)
    }

    /**
     * Método para asociar un producto a las vistas dentro del ViewHolder.
     * @param item El producto a mostrar.
     */
    @SuppressLint("SetTextI18n")
    fun bind(item: Product) {
        this.product = item
        // Cargar la imagen del producto utilizando Glide.
        Glide.with(itemBinding.root).load(item.thumbnail).centerInside()
            .into(itemBinding.imageViewProduct)
        // Establecer el título del producto.
        itemBinding.textViewTitle.text = item.title.take(60) // Limitar el título a 60 caracteres.
        // Establecer el precio del producto formateado como moneda COP (pesos colombianos).
        itemBinding.textViewPrice.text = "$ ${NumberHelper().parseAmountToCOP(item.price)}"
        // Establecer las cuotas del producto si están disponibles.
        if (item.installments != null) itemBinding.textViewInstallments.text =
            "${item.installments.quantity}x $${NumberHelper().parseAmountToCOP(item.installments.amount)}"
        // Establecer la cantidad disponible del producto.
        itemBinding.textViewQuantity.text = "${item.availableQuantity}"
    }

    /**
     * Método invocado cuando se hace clic en el ViewHolder.
     * Notifica al listener que se ha hecho clic en el producto asociado.
     */
    override fun onClick(view: View?) {
        listener.onClickedProduct(product)
    }

}
