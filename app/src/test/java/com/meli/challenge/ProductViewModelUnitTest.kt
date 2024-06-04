package com.meli.challenge

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.meli.challenge.data.model.Product
import com.meli.challenge.data.model.ProductResponse
import com.meli.challenge.data.network.ApiResponse
import com.meli.challenge.domain.GetProductsUseCase
import com.meli.challenge.ui.product.ProductViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.net.HttpURLConnection

@ExperimentalCoroutinesApi
class ProductViewModelUnitTest {

    @RelaxedMockK
    private lateinit var getProductsUseCase: GetProductsUseCase

    private lateinit var productViewModel: ProductViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        productViewModel = ProductViewModel(getProductsUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when getProductsUseCase return any products set on the livedata`() = runTest {
        //Given
        val product = Product()
        product.id = "MCO1119374781"
        product.title = "TES1"
        val products = arrayListOf(product, product)
        val response = ApiResponse<ProductResponse>()
        response.httpCode = HttpURLConnection.HTTP_OK
        response.body = ProductResponse(products)
        coEvery { getProductsUseCase(any()) } returns response
        //When
        productViewModel.getProducts("")
        //Then
        assert(productViewModel.productLiveData.value == response.body!!.results)
    }

    @Test
    fun `when getProductsUseCase return HTTP_OK and empty list`() = runTest {
        //Given
        val response = ApiResponse<ProductResponse>()
        response.httpCode = HttpURLConnection.HTTP_OK
        response.body = ProductResponse(ArrayList())
        coEvery { getProductsUseCase(any()) } returns response
        //When
        productViewModel.getProducts("")
        //Then
        assert(productViewModel.productLiveData.value!!.size == response.body!!.results.size)
    }

    @Test
    fun `when getProductsUseCase return HTTP_OK and two size list`() = runTest {
        //Given
        val product = Product()
        product.id = "MCO1119374781"
        product.title = "TES1"
        val products = arrayListOf(product, product)
        val response = ApiResponse<ProductResponse>()
        response.httpCode = HttpURLConnection.HTTP_OK
        response.body = ProductResponse(products)
        coEvery { getProductsUseCase(any()) } returns response
        //When
        productViewModel.getProducts(product.title)
        //Then
        assert(productViewModel.productLiveData.value!!.size == response.body!!.results.size)
    }

    @Test
    fun `if getProductsUseCase return null keep the last value`() = runTest {
        //Given
        val product = Product()
        product.id = "MCO1119374781"
        product.title = "monello"
        val products = arrayListOf(product, product)
        val response = ApiResponse<ProductResponse>()
        response.httpCode = HttpURLConnection.HTTP_OK
        response.body = ProductResponse(products)
        productViewModel.productLiveData.value = response.body!!.results
        coEvery { getProductsUseCase(any()) } returns ApiResponse()
        //When
        productViewModel.getProducts(product.title)
        //Then
        assert(
            productViewModel.productLiveData.value!! == response.body!!.results
        )
    }

    @Test
    fun `if getProductsUseCase return anything error set on errorCode livedata`() = runTest {
        //Given
        val response = ApiResponse<ProductResponse>()
        response.httpCode = HttpURLConnection.HTTP_BAD_REQUEST
        response.body = ProductResponse(ArrayList())
        coEvery { getProductsUseCase(any()) } returns response
        //When
        productViewModel.getProducts("")
        //Then
        assert(productViewModel.errorCode.value == response.httpCode)
    }

    @Test
    fun `if getProductsUseCase return error and response code is HTTP_UNAVAILABLE`() = runTest {
        //Given
        val response = ApiResponse<ProductResponse>()
        response.httpCode = HttpURLConnection.HTTP_UNAVAILABLE
        response.errorMessage = "error internet connection"
        response.body = ProductResponse(ArrayList())
        coEvery { getProductsUseCase(any()) } returns response
        //When
        productViewModel.getProducts("")
        //Then
        assert(productViewModel.errorCode.value!! == response.httpCode)
    }

    @Test
    fun `if getProductsUseCase return error and response code is HTTP_INTERNAL_ERROR`() = runTest {
        //Given
        val response = ApiResponse<ProductResponse>()
        response.httpCode = HttpURLConnection.HTTP_INTERNAL_ERROR
        response.errorMessage = "internal server error"
        response.body = ProductResponse(ArrayList())
        coEvery { getProductsUseCase(any()) } returns response
        //When
        productViewModel.getProducts("")
        //Then
        assert(productViewModel.errorCode.value!! == response.httpCode)
    }

    @Test
    fun `if getProductsUseCase return anything set false on loading livedata`() = runTest {
        //Given
        val response = ApiResponse<ProductResponse>()
        response.httpCode = HttpURLConnection.HTTP_OK
        response.body = ProductResponse(ArrayList())
        coEvery { getProductsUseCase(any()) } returns response
        //When
        productViewModel.getProducts("")
        //Then
        assert(productViewModel.loading.value == false)
    }

}