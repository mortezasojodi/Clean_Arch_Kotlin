package com.msa.cleanauth.ui.screens.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.devrunsoft.msamusic.ui.styling.Dimensions
import com.devrunsoft.msamusic.ui.styling.LocalAppearance
import com.devrunsoft.msamusic.ui.styling.shimmer
import com.msa.cleanauth.ui.components.ItemContainer
import com.msa.cleanauth.ui.components.ItemInfoContainer
import com.msa.cleanauth.ui.components.ShimmerHost
import com.msa.cleanauth.ui.screens.globalRoutes
import com.msa.cleanauth.ui.screens.productDetailRoute
import com.msa.cleanauth.ui.screens.product_detail.ProductDetailScreen
import com.msa.compose.routing.RouteHandler
import com.msa.domain.entities.ProductEntity
import kotlin.random.Random

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun HomeScreen( productViewModel: ProductViewModel) {
    val isLoading = productViewModel.isLoading.value
    val userList = productViewModel.userData.collectAsState().value
    LaunchedEffect(Unit) {
        productViewModel.getAllUser()
    }

    RouteHandler(listenToGlobalEmitter = true){
        globalRoutes()
        productDetailRoute { browseId ->
            ProductDetailScreen(
                model = browseId ?: error("browseId cannot be null")
            )
        }

        host {
            if (isLoading) {
                ProductBoxLoading()
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    userList.forEach { product ->
                        items( productViewModel.userData.value.size) {
                            ProductBox(model = product,onDetail={ productDetailRoute(it)})
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProductBox(model: ProductEntity, onDetail : (ProductEntity)-> Unit){
Card(
    modifier = Modifier
        .padding(5.dp, 4.dp, 5.dp, 4.dp)
        .fillMaxWidth()
        .clickable(indication = rememberRipple(bounded = true),
            interactionSource = remember { MutableInteractionSource() }) {
            onDetail(model)
        },
    shape = RoundedCornerShape(CornerSize(5.dp)),
//    elevation = 4.dp,
) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(model = model.image),
            contentDescription = "image",
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(CornerSize(10.dp)))

        )
        Column {
            Text(
                modifier = Modifier.padding(5.dp),
                text = model.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium,
//                fontFamily = fontLexend
            )

            Text(
                text =  model.category,
                maxLines = 1,
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.titleMedium,
//                fontFamily = fontLexend
            )

            Text(
                text =  model.description,
                maxLines = 5,
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.titleSmall,
//                fontFamily = fontLexend
            )
        }
    }
}
}

@Composable
fun ProductBoxLoading(){
    ShimmerHost {
        repeat(10) {
            ProductPlaceholder(thumbnailSizeDp = 100.dp)
        }
    }
}

@Composable
fun ProductPlaceholder(
    thumbnailSizeDp: Dp,
    modifier: Modifier = Modifier
) {

    ItemContainer(
        alternative = false,
        thumbnailSizeDp =thumbnailSizeDp,
        modifier = modifier,
        verticalAlignment =  Alignment.Top
    ) {
        Spacer(
            modifier = Modifier
                .background(color =  Color(0xff838383))
                .size(thumbnailSizeDp)
        )

        ItemInfoContainer {
            TextPlaceholder()
            TextPlaceholder()
        }
    }
}
@Composable
fun TextPlaceholder(
    modifier: Modifier = Modifier,
    color: Color = Color(0xff838383)
) {
    Spacer(
        modifier = modifier
            .padding(vertical = 4.dp)
            .background(color)
            .fillMaxWidth(remember { 0.25f + Random.nextFloat() * 0.5f })
            .height(16.dp)
    )
}
