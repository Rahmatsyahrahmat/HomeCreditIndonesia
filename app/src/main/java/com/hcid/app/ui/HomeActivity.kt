package com.hcid.app.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hcid.app.R
import com.hcid.app.domain.common.Resource
import com.hcid.app.ui.adapter.ArticleAdapter
import com.hcid.app.ui.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel:HomeViewModel by viewModels()

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

        viewModel.products.observe(this){resource->
            when(resource){
                is Resource.Success->{

                }
                is Resource.Loading->{

                }
                is Resource.Error->{

                }
            }
        }

        viewModel.articles.observe(this){resource->
            when(resource){
                is Resource.Success->{

                }
                is Resource.Loading->{

                }
                is Resource.Error->{

                }
            }
        }

        viewModel.articleSectionTitle.observe(this){resource->
            when(resource){
                is Resource.Success->{

                }
                is Resource.Loading->{

                }
                is Resource.Error->{

                }
            }
        }

    }

}