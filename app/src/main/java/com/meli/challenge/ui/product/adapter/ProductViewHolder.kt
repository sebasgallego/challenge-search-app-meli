package com.meli.challenge.ui.product.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.meli.challenge.utils.NumberHelper
import com.meli.challenge.data.model.Product
import com.meli.challenge.databinding.ListItemProductBinding


class ProductViewHolder(
    private val itemBinding: ListItemProductBinding
) : RecyclerView.ViewHolder(itemBinding.root) {
    private lateinit var product: Product

    fun bind(item: Product) {
        this.product = item
        Glide.with(itemBinding.root).load(item.thumbnail).centerInside()
            .into(itemBinding.imageViewProduct)
        itemBinding.textViewTitle.text = item.title.take(60)
        itemBinding.textViewPrice.text = "$ ${NumberHelper().parseAmountToCOP(item.price)}"
        if (item.installments != null) itemBinding.textViewInstallments.text =
            "${item.installments!!.quantity}x $${NumberHelper().parseAmountToCOP(item.installments!!.amount)}"
        itemBinding.textViewQuantity.text = "${item.availableQuantity}"
    }

}