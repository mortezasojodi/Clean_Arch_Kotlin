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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {

    val isLoading = mutableStateOf(false)
    private val _userData = MutableStateFlow<List<ProductEntity>>(emptyList())
    val userData = _userData.asStateFlow()

    //Detail Screen variable
//    var user by mutableStateOf<ProductEntity?>(null)
//        private set

//    init {
//        getAllUser()
//    }

    fun getAllUser() = viewModelScope.launch {
        isLoading.value = true
        val fetchUserListEntity = repository.getAll()
        fetchUserListEntity.onSuccess {
            _userData.value=it;
        }
//        _userData.value = listOf(fetchUserListEntity)
    }.invokeOnCompletion {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            isLoading.value = false
        }, 3000)
    }

//    fun addUser(newUser: ProductEntity) {
//        user = newUser
//    }
}