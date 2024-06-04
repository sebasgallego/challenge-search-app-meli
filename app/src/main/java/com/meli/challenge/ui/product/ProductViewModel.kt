package com.meli.challenge.ui.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meli.challenge.data.model.Product
import com.meli.challenge.domain.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {
    // Expose screen UI product
    val productLiveData = MutableLiveData<ArrayList<Product>>()
    //Loading
    val loading = MutableLiveData<Boolean>()
     val errorCode = MutableLiveData<Int?>()

    /**
     * get products
     */
    fun getProducts(nameProduct: String) {
        viewModelScope.launch {
            loading.value = true
            val response = getProductsUseCase.invoke(nameProduct)
            if (response.httpCode == HttpURLConnection.HTTP_OK) {
                response.body?.let { productLiveData.postValue(it) }
                errorCode.value = null
            } else {
                errorCode.value = response.httpCode
            }
            loading.value = false
        }
    }
}