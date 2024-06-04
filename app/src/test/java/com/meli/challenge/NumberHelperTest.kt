package com.meli.challenge

import com.meli.challenge.utils.NumberHelper
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class NumberHelperTest {
    @Test
    fun parseAmountToCOP_isCorrect() {
       val numberHelper = NumberHelper()
        assertEquals("20,000", numberHelper.parseAmountToCOP(20000.00))
    }
}