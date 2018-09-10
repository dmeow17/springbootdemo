package com.derek.springbootdemo.interfaces

import com.derek.springbootdemo.domains.MarketService
import com.derek.springbootdemo.domains.Order
import com.derek.springbootdemo.domains.Order.Way
import com.derek.springbootdemo.domains.PortfolioService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/market")
class MarketController(
        private val marketService: MarketService,
        private val portfolioService: PortfolioService) {
    companion object {
        private const val EXECUTIONS_URL = "/executions"
    }

    @GetMapping("/price")
    fun getLastPrice() = marketService.getLastPrice()

    @GetMapping(EXECUTIONS_URL)
    fun getExecutions() = portfolioService.getExecutions()

    @PostMapping(EXECUTIONS_URL)
    fun addExecution(@RequestParam size: Int, @RequestParam way: Way) =
            portfolioService.addExecution(Order(size, way))

    @GetMapping("$EXECUTIONS_URL/notional")
    fun computeNotional() = portfolioService.computeNotional()
}
