package com.msa.cleanauth.ui.screens.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.msa.cleanauth.ui.screens.globalRoutes
import com.msa.compose.routing.RouteHandler
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun HomeScreen() {
    RouteHandler(listenToGlobalEmitter = true){
        globalRoutes()

        host {
Text(text = "ssss")
        }
    }
}