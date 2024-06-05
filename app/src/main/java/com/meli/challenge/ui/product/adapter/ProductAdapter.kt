package com.meli.challenge.ui.product.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meli.challenge.data.model.Product
import com.meli.challenge.databinding.ListItemProductBinding

/**
 * Adaptador para la lista de productos en la pantalla de productos.
 */
class ProductAdapter(
    private val listener: ProductItemListener
) : RecyclerView.Adapter<ProductViewHolder>() {

    private var itemList: MutableList<Product> = ArrayList()

    interface ProductItemListener {
        fun onClickedProduct(product: Product)
    }

    /**
     * Crea y devuelve un nuevo ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding: ListItemProductBinding =
            ListItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding,listener)
    }

    /**
     * Enlaza los datos de un producto con el ViewHolder.
     */
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    /**
     * Reemplaza la lista de productos con una nueva lista y notifica el cambio.
     */
    @SuppressLint("NotifyDataSetChanged")
    fun newItems(items: MutableList<Product>) {
        this.itemList.clear()
        this.itemList.addAll(items)
        notifyDataSetChanged()
    }

    /**
     * Obtiene el número total de elementos en la lista.
     */
    override fun getItemCount(): Int = itemList.size
}
