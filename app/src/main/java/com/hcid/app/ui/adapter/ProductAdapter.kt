package com.hcid.app.ui.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hcid.app.R
import com.hcid.app.domain.entity.Product
import com.hcid.app.ui.util.ProductDiffCallback
import kotlinx.android.synthetic.main.view_item_product.view.*

class ProductAdapter (private val context: Context):RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    private val products:ArrayList<Product> = arrayListOf()

    fun setProducts(products:List<Product>){
        val diffCallback = ProductDiffCallback(this.products,products)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.products.clear()
        this.products.addAll(products)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.view_item_product,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(products[position].link)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = products.size

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product){
            Glide.with(itemView.context).load(product.image).into(itemView.productImage)
            itemView.productName.text = product.name
        }
    }

}