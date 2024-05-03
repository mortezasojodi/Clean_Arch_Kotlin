package com.msa.cleanauth.ui.screens.home

import android.os.Handler
import android.os.Looper
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msa.domain.entities.ProductData
import com.msa.domain.entities.ProductEntity
import com.msa.domain.repository.ProductRepository
import com.msa.domain.usecase.ProductGetAllUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val useCase: ProductGetAllUseCase) : ViewModel() {

    val isLoading = mutableStateOf(false)
    private val _userData = MutableStateFlow<List<ProductEntity>>(emptyList())
    val userData = _userData.asStateFlow()

    fun getAllUser() = viewModelScope.launch {
        isLoading.value = true
        val fetchUserListEntity = useCase.getAll()
        fetchUserListEntity.onSuccess {
            _userData.value=it;
        }.onFailure {
            print("")
        }
    }.invokeOnCompletion {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            isLoading.value = false
        }, 3000)
    }

}