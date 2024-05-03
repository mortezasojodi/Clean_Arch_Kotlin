package com.msa.cleanauth.ui.screens.product_detail

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.msa.domain.entities.ProductEntity

@Composable
fun ProductDetailScreen(model : ProductEntity) {
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
//    val screenWidth = configuration.screenWidthDp.dp
    Scaffold() {padding ->
        Column {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = model.image),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()

                        .size(height = screenHeight / 2, width = 0.dp),
                    contentDescription = model.title,
                )
                Column( modifier = Modifier.padding(10.dp)) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = model.title,
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleLarge,
                    )

                    Text(
                        text =  model.category,
                        maxLines = 1,
                        modifier = Modifier.padding(5.dp),
                        style = MaterialTheme.typography.titleMedium,
                    )

                    Text(
                        text =  model.description,
                        maxLines = 5,
                        modifier = Modifier.padding(5.dp),
                        style = MaterialTheme.typography.titleSmall,
                    )
                }

            }

        }
    }

}
