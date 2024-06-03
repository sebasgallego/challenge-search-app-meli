package com.meli.challenge.ui.product.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meli.challenge.data.model.Product
import com.meli.challenge.databinding.ListItemProductBinding

class ProductAdapter : RecyclerView.Adapter<ProductViewHolder>() {

    private var itemList: MutableList<Product> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding: ListItemProductBinding =
            ListItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    /**
     * on Bind ViewHolder
     */
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    /**
     * new Items
     */
    @SuppressLint("NotifyDataSetChanged")
    fun newItems(items: MutableList<Product>) {
        this.itemList.clear()
        this.itemList.addAll(items)
        notifyDataSetChanged()
    }

    /**
     * get Item Count
     */
    override fun getItemCount(): Int = itemList.size
}