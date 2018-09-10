package com.derek.springbootdemo.domains

import com.derek.springbootdemo.domains.Order.Way.Buy
import org.springframework.stereotype.Service

@Service
class PortfolioService(private val marketService: MarketService) {
    private val executions = mutableListOf<Execution>()

    fun getExecutions() = executions

    fun addExecution(order: Order): Execution {
        val execution = Execution(order, marketService.getLastPrice())
        executions.add(execution)
        return execution
    }

    fun computeNotional(product: String?): Double {
        val (buyExecutions, sellExecutions) = executions
                .filter { it.order.product == product }
                .partition { it.order.way == Buy }
        return buyExecutions.notional() - sellExecutions.notional()
    }

    private fun List<Execution>.notional() = this.map { it.order.size * it.price }.sum()
}