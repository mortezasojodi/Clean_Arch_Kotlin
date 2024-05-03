package com.msa.cleanauth.ui.screens

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import com.msa.cleanauth.ui.screens.product_detail.ProductDetailScreen
import com.msa.compose.routing.Route1
import com.msa.compose.routing.RouteHandlerScope
import com.msa.domain.entities.ProductEntity

val productDetailRoute = Route1<ProductEntity?>("productDetailRoute")
//@SuppressLint("ComposableNaming")
//@Suppress("NOTHING_TO_INLINE")
//@ExperimentalAnimationApi
//@ExperimentalFoundationApi
//@Composable
//inline fun RouteHandlerScope.globalRoutes() {
//
//}
