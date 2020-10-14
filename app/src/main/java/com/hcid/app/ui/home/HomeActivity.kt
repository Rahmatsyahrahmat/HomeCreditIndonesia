package com.hcid.app.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hcid.app.R
import com.hcid.app.domain.common.Resource
import com.hcid.app.ui.adapter.ArticleAdapter
import com.hcid.app.ui.adapter.ProductAdapter
import com.hcid.app.ui.hide
import com.hcid.app.ui.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.content_main.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()

    private val productAdapter:ProductAdapter by lazy {
        ProductAdapter(this)
    }
    private val articleAdapter:ArticleAdapter by lazy {
        ArticleAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeProductList.adapter = productAdapter
        homeArticleList.adapter = articleAdapter

        viewModel.getProducts().observe(this){resource->
            when(resource){
                is Resource.Success->{
                    resource.data?.let {
                        productAdapter.setProducts(it)
                    }
                    homeProductsShimmer.hide()
                }
                is Resource.Loading->{
                    if (resource.data.isNullOrEmpty()){
                        homeProductsShimmer.show()
                    }else{
                        productAdapter.setProducts(resource.data)
                        homeProductsShimmer.hide()
                    }
                }
                is Resource.Error->{
                    Toast.makeText(this,resource.message.toString(),Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.getArticles().observe(this){resource->
            when(resource){
                is Resource.Success->{
                    resource.data?.let {
                        articleAdapter.setArticles(it)
                    }
                    homeArticlesShimmer.hide()
                }
                is Resource.Loading->{
                    if (resource.data.isNullOrEmpty()){
                        homeArticlesShimmer.show()
                    }else{
                        articleAdapter.setArticles(resource.data)
                        homeArticlesShimmer.hide()
                    }
                }
                is Resource.Error->{
                    Toast.makeText(this,resource.message.toString(),Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.getArticleSectionTitle().observe(this){resource->
            when(resource){
                is Resource.Success->{
                    homeArticleSectionTitle.text = resource.data
                    homeArticleSectionTitleShimmer.hide()
                }
                is Resource.Loading->{
                    if (resource.data.isNullOrBlank()){
                        homeArticleSectionTitleShimmer.show()
                    }else{
                        homeArticleSectionTitle.text = resource.data
                        homeArticleSectionTitleShimmer.hide()
                    }
                }
                is Resource.Error->{
                    Toast.makeText(this,resource.message.toString(),Toast.LENGTH_SHORT).show()
                }
            }
        }

    }


}

