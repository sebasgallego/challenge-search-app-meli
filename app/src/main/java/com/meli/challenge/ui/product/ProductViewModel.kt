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

/**
 * ViewModel para la pantalla de productos.
 * Administra la obtención de productos y maneja el estado de carga y errores.
 *
 * @property getProductsUseCase Caso de uso para obtener productos desde el repositorio.
 */
@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    // LiveData para exponer la lista de productos a la IU
    val productLiveData = MutableLiveData<ArrayList<Product>>()

    // LiveData para controlar el estado de carga
    val loading = MutableLiveData<Boolean>()

    // LiveData para manejar los errores de la solicitud HTTP
    val errorCode = MutableLiveData<Int?>()

    // Bandera para indicar si la solicitud fue exitosa
    var isSuccess: Boolean = false

    /**
     * Obtiene la lista de productos correspondientes al nombre de producto proporcionado.
     *
     * @param nameProduct Nombre del producto a buscar.
     */
    fun getProducts(nameProduct: String) {
        viewModelScope.launch {
            // Indicar que se está cargando
            loading.value = true

            // Invocar al caso de uso para obtener los productos
            val response = getProductsUseCase.invoke(nameProduct)

            // Verificar el código de estado de la respuesta HTTP
            if (response.httpCode == HttpURLConnection.HTTP_OK) {
                // Si la respuesta es exitosa, actualizar la lista de productos
                response.body?.let { body -> productLiveData.postValue(body.results) }
                // Limpiar el código de error
                errorCode.value = null
                // Marcar la solicitud como exitosa
                isSuccess = true
            } else {
                // Si hay un error en la respuesta, actualizar el código de error
                errorCode.value = response.httpCode
            }

            // Indicar que la carga ha finalizado
            loading.value = false
        }
    }

}
