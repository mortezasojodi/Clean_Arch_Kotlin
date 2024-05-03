package com.msa.cleanauth

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.msa.cleanauth.ui.screens.home.HomeScreen
import com.msa.cleanauth.ui.screens.home.ProductViewModel
import com.msa.cleanauth.ui.screens.productDetailRoute

import com.msa.cleanauth.ui.theme.CleanAuthTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: ProductViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {

            CleanAuthTheme {
                MainScreen(viewModel)
            }
        }
    }
}
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun MainScreen(viewModel: ProductViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
                 }
        HomeScreen(
            productViewModel = viewModel,

        )
    }
