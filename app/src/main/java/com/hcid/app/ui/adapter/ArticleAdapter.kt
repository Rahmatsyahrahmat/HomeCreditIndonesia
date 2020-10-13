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
import com.hcid.app.domain.entity.Article
import com.hcid.app.ui.util.ArticleDiffCallback
import kotlinx.android.synthetic.main.view_item_article.view.*

class ArticleAdapter(private val context:Context):RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){

    private val articles:ArrayList<Article> =  arrayListOf()

    fun setArticles(articles:List<Article>){
        val diffCallback = ArticleDiffCallback(this.articles,articles)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.articles.clear()
        this.articles.addAll(articles)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.view_item_article,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articles[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(articles[position].link)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = articles.size


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article){
            Glide.with(itemView.context).load(article.image).into(itemView.articleImage)
            itemView.articleTitle.text = article.title
        }
    }

}