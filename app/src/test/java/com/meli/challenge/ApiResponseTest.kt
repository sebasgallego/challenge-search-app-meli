package com.meli.challenge

import com.meli.challenge.data.network.ApiResponse
import org.junit.Assert.assertEquals
import org.junit.Test
import java.net.HttpURLConnection

class ApiResponseTest {

    @Test
    fun testDefaultValues() {
        // Arrange
        val expectedHttpCode = HttpURLConnection.HTTP_OK
        val expectedBody: String? = null
        val expectedErrorMessage: String? = null

        // Act
        val apiResponse = ApiResponse<String>()

        // Assert
        assertEquals(expectedHttpCode, apiResponse.httpCode)
        assertEquals(expectedBody, apiResponse.body)
        assertEquals(expectedErrorMessage, apiResponse.errorMessage)
    }

    @Test
    fun testCustomValues() {
        // Arrange
        val expectedHttpCode = HttpURLConnection.HTTP_BAD_REQUEST
        val expectedBody = "Error body"
        val expectedErrorMessage = "Bad request"

        // Act
        val apiResponse = ApiResponse(
            httpCode = expectedHttpCode,
            body = expectedBody,
            errorMessage = expectedErrorMessage
        )

        // Assert
        assertEquals(expectedHttpCode, apiResponse.httpCode)
        assertEquals(expectedBody, apiResponse.body)
        assertEquals(expectedErrorMessage, apiResponse.errorMessage)
    }
}
