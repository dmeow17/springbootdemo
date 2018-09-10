package com.derek.springbootdemo.domains

import com.derek.springbootdemo.domains.Order.Way.Buy
import com.derek.springbootdemo.domains.Order.Way.Sell
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PortfolioServiceTest {
    private val marketService: MarketService = mockk()
    private val portfolioService: PortfolioService = PortfolioService(marketService)

    @BeforeEach
    fun setUp() {
        every { marketService.getLastPrice() } returns 100.0
        portfolioService.addExecution(Order(30, Buy, null))
        portfolioService.addExecution(Order(30, Buy, "BTC"))
        portfolioService.addExecution(Order(20, Sell, null))
    }

    @Test
    fun `Test computeNotional, when no filter, expect compute for all product`() {
        val actual = portfolioService.computeNotional(null)
        assertEquals(actual, 4000.0)
    }

    @Test
    fun `Test computeNotional, when filter = BTC, expect compute for BTC only`() {
        val actual = portfolioService.computeNotional("BTC")
        assertEquals(actual, 3000.0)
    }
}
