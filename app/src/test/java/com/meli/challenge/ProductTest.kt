package com.meli.challenge
import com.meli.challenge.data.model.Attribute
import com.meli.challenge.data.model.Product
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductTest {

    @Test
    fun getItemAttributes_withValidType_shouldReturnCorrectValue() {
        // Given
        val product = Product(
            id = "MCO1396823553",
            title = "Moto G6 Play 16 Gb Índigo Oscuro 2 Gb Ram",
            thumbnail = "http://http2.mlstatic.com/D_855228-MLA44190758269_112020-I.jpg",
            price = 10.0,
            availableQuantity = 100,
            installments = null,
            attributes = listOf(
                Attribute(id = "1", valueName = "Red"),
                Attribute(id = "2", valueName = "Large"),
                Attribute(id = "3", valueName = "Cotton")
            )
        )

        // When
        val result = product.getItemAttributes("2") // Get attribute with id "2"

        // Then
        assertEquals("Large", result)
    }

    @Test
    fun getItemAttributes_withInvalidType_shouldReturnEmptyString() {
        // Given
        val product = Product(
            id = "MCO1396823553",
            title = "Moto G6 Play 16 Gb Índigo Oscuro 2 Gb Ram",
            thumbnail = "http://http2.mlstatic.com/D_855228-MLA44190758269_112020-I.jpg",
            price = 10.0,
            availableQuantity = 100,
            installments = null,
            attributes = listOf(
                Attribute(id = "1", valueName = "Red"),
                Attribute(id = "2", valueName = "Large"),
                Attribute(id = "3", valueName = "Cotton")
            )
        )

        // When
        val result = product.getItemAttributes("4") // Get attribute with id "4" (non-existent)

        // Then
        assertEquals("", result)
    }

    @Test
    fun getPriceFormat_withValidPrice_shouldReturnFormattedPrice() {
        // Given
        val product = Product(
            id = "MCO1396823553",
            title = "Moto G6 Play 16 Gb Índigo Oscuro 2 Gb Ram",
            thumbnail = "http://http2.mlstatic.com/D_855228-MLA44190758269_112020-I.jpg",
            price = 10000.0, // COP 10,000.0
            availableQuantity = 100,
            installments = null,
            attributes = null
        )

        // When
        val result = product.getPriceFormat(10000.0)

        // Then
        assertEquals("10,000", result)
    }

}
