package com.meli.challenge
import android.app.Activity
import com.meli.challenge.utils.ViewHelper
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.net.HttpURLConnection

class ViewHelperTest {


    private lateinit var viewHelper: ViewHelper
    private lateinit var mockActivity: Activity

    @Before
    fun setup() {
        mockActivity = mock(Activity::class.java)
        viewHelper = ViewHelper(mockActivity)
    }

    @Test
    fun `processMsgError with HTTP_UNAVAILABLE code`() {
        // Mock HTTP_UNAVAILABLE code
        val code = HttpURLConnection.HTTP_UNAVAILABLE
        val expectedMessage = "Internet Error"
        `when`(mockActivity.getString(R.string.error_internet)).thenReturn(expectedMessage)

        // Invoke processMsgError
        val result = viewHelper.processMsgError(code)

        // Assert result
        assertEquals(expectedMessage, result)
    }

    @Test
    fun `processMsgError with other code`() {
        // Mock other error code
        val code = HttpURLConnection.HTTP_NOT_FOUND
        val expectedMessage = "Server Error"
        `when`(mockActivity.getString(R.string.error_server)).thenReturn(expectedMessage)

        // Invoke processMsgError
        val result = viewHelper.processMsgError(code)

        // Assert result
        assertEquals(expectedMessage, result)
    }
}
